@Path("/")
public class WelcomeResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response produceHTML() {
        String html = "<p>Hello, World!</p>";
        return Response.ok(html).build();
    }
}