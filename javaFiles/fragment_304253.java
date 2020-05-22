@Path("/widgets")
public class WidgetResource {

    @Inject
    WidgetService widgetService;

    @POST
    @Consumes(...)
    public Response createWidget(@Context UriInfo uriInfo, Widget widget) {
        Widget created = widgetService.createWidget(widget);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        URI uri = builder.path(created.getId()).build();

        return Response.created(uri).build();
    }
}