@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class Example{

  @GET
  public Response sayHello() {
    return Response.ok("Hello world").type(MediaType.TEXT_HTML).build();
  }

}