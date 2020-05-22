@Path("/test")
public class TestResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
       return "Hello World";
    }
}