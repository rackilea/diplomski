@Path("/")
@Produces(MediaType.APPLICATION_XML)
public class WidgetResource {

  @GET
  @Path("widgets")
  public Response getWidgets(@QueryParam("limit")) {
   //This method returns the plural noun, a list of widgets
  //...}

  @GET
  @Path("widget/{id}")
  public Response getWidgetById(@PathParam("id") long id) {
    //This method returns a single widget by id
    //...
  }
}