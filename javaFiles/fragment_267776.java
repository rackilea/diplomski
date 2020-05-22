@Path("/")
public class MyEndpoint {

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response myMethod(@PathParam("id") Long id) {
        // This method is not annotated with @Logged
        // The logging filters won't be executed when invoking this method
        ...
    }

    @DELETE
    @Logged
    @Path("{id}")
    @Produces("application/json")
    public Response myLoggedMethod(@PathParam("id") Long id) {
        // This method is annotated with @Logged
        // The request logging filter will be executed before invoking this method
        // The response logging filter will be executed before invoking this method
        ...
    }
}