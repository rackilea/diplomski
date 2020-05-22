@Path("/config")
@ConfiguredBy("AppConfiguration")
public class ConfigResource {

    @Configured
    String hello;

    @GET
    public Response getHello() {
        return Response.ok(hello).build();
    }
}