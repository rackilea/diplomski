@Path("/config")
public class ConfigResource {

    @Named("hello.config")
    String hello;

    @GET
    public Response getHello() {
        return Response.ok(hello).build();
    }
}