@Path("widgets")
@Produces(MediaType.APPLICATION_XML)
public class WidgetResource {

  @GET
  public Response getWidgets(@QueryParam("limit")) {
   //This method returns the plural noun, a list of widgets
   // it's also possible to limit the number returned by
   // using a query parameter. You could easily implement
   // pagination by adding further query parameters like
   // 'offset', 'sortOrder', etc.
   //...
  }

  @GET
  @Path("{id}")
  public Response getWidgetById(@PathParam("id") long id) {
    //This method returns a single widget by id
    //...
  }
}