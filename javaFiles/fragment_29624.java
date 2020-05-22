package org.apache.wink.example.helloworld;

import java.util.*;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.apache.wink.common.model.synd.*;

@Path("/world")
public class HelloWorld {

    @Context
    private ServletContext context;

    public static final String ID = "helloworld:1";

    @GET
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public SyndEntry getGreeting() {

        Map<String, String> dummyCache = 
                       (Map<String, String>) context.getAttribute("dummyCache");

        String text = dummyCache.get("greeting");

        SyndEntry synd = new SyndEntry(new SyndText(text), ID, new Date());
        return synd;
    }

}