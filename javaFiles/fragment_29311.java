package jersey.servlet.initializer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/resource")
public class Resource {

    @GET
    public Response getResponse() {
        return Response.ok("ServletContainerInitializer test OK!").build();
    }
}