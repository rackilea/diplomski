package com.example.cxfboot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RequestParam;

@Path("/main")
public class ControllerClass {
    @GET
    @Path("/cxf")
    public String addcsf(@RequestParam String name) {

        System.out.println("Ghanta");

        return "BC";

    }

}