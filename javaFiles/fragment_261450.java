package com.application.my;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/post-stuff")
@Produces(MediaType.APPLICATION_JSON)
public final class TestResource {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response execute(
            @FormParam("form_param_1") final String formParam1,
            @FormParam("form_param_2") final String formParam2
    ) {
        System.out.println("form param_1: " + formParam1);
        System.out.println("form param_2: " + formParam2);

        return Response.created(URI.create("/")).entity("{}").build();
    }
}