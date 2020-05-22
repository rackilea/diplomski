@Path("my-service")
@RequestScoped // either CDI-bean
//@Stateless // or EJB
public class MyResource {

  @Inject // inject custom context via CDI
  private MyCustomContext customContext;

  @GET
  @Path("get-stuff")
  @Produces(MediaType.APPLICATION_JSON)
  public Response doStuff() {
    // ... use the customContext here.
  }
}