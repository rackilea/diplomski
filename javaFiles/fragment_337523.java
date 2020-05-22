package com.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class SpringRestController {

@RequestMapping(method = { RequestMethod.GET }, value = { "/testApplication" }, consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
public String getServerInfo() {
    System.out.println("I got hit");
    String message = "Hit the end point";
    return message;
}