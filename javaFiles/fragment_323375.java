@Path("my-service")
@RequestScoped // CDI-bean with request scope only
public class MyResource {

  @Context
  private HttpServletRequest request;

  private MyCustomContext customContext;

  @PostConstruct
  public void initialize() {
    this.customContext = new MyCustomContext(this.request); // request is initialized by the container already at this point
  }

  @GET
  @Path("get-stuff")
  @Produces(MediaType.APPLICATION_JSON)
  public Response doStuff() {
    // ... use the customContext here.
  }
}