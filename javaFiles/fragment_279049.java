public class Service {

  @GET
  @Path("/example")
  @RolesAllowed({ "BASIC_USER", "ADMIN" })
  public Response foo() {
    return new Response();
}