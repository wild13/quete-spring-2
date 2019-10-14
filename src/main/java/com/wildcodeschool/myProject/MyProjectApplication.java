package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class MyProjectApplication {

    public static void main( String[] args ) {
        SpringApplication.run( MyProjectApplication.class, args );
    }

    @RequestMapping( "/doctor/{id}" )
    @ResponseBody
    public String getDoctor( @PathVariable int id ) {
        String message = "";
        if ( id >= 1 && id <= 8 ) {
            throw new ResponseStatusException( HttpStatus.SEE_OTHER, "303 See Other." );
        } else if ( id >= 9 && id <= 13 ) {
            switch ( id ) {
            case 9:
                message = "{ number: " + id + ", name:" + " Christopher Eccleston}";
                break;
            case 10:
                message = "{ number: " + id + ", name:" + " David Tennant}";
                break;
            case 11:
                message = "{ number: " + id + ", name:" + " Matt Smith}";
                break;
            case 12:
                message = "{ number: " + id + ", name:" + " Peter Capaldi}";
                break;
            case 13:
                message = "{ number: " + id + ", name:" + " Jodie Whittaker}";
                break;
            default:
                message = "";
            }
        } else {
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,
                    "\"Impossible de récupérer l'incarnation <" + id + ">\"" );
        }
        return message;
    }
}