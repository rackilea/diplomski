@Path("{any: .*}")
public class NotFoundService {

  @GET
  @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
  public Response getNotFound(@Context UriInfo uriInfo) {
    // My custom response where I can use uriInfo to tell what went wrong
  }
}