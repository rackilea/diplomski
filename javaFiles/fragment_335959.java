@Path("/foo")
@WebService
public class FooService {
    @Path("/bar")
    @GET
    @WebMethod
    public Response bar() {
        return Response.ok().type("text/plain").entity("hi").build();
    }
    ...