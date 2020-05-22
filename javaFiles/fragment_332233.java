@ApplicationPath("/ide")
public class Rest extends Application { }


@Path("/hello")
public class HelloResource {

  @GET
  @Path("hello")
  public String helloworld() {
      return "Hello World!";
  }
}