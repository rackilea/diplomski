@Path("my-service")
@RequestScoped // either CDI-bean
//@Stateless // or EJB
public class MyResource {

  @Context // in JAX-RS context the instance will not be null
  private Request request;
  @Inject
  private MyCustomContext customContext;

  @Produces // provide the JAX-RS context instance for injection via CDI
  @RequestScoped
  public Request getContextRequest() {
    return this.request;
  }

  @GET
  @Path("get-stuff")
  @Produces(MediaType.APPLICATION_JSON)
  public Response doStuff() {
    // ... use the customContext here.
  }
}