import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import protobuf.example.WidgetsProtoc.Widget;
import protobuf.example.WidgetsProtoc.WidgetList;

@Path("/widgets")
public class WidgetResource {

    @GET
    @Produces("application/protobuf")
    public Response getAllWidgets() {
        Widget widget1 = 
                Widget.newBuilder().setId("1").setName("widget 1").build();
        Widget widget2 = 
                Widget.newBuilder().setId("2").setName("widget 2").build();
        WidgetList list = WidgetList.newBuilder()
                .addWidget(widget1).addWidget(widget2).build();
        return Response.ok(list).build();
    }

    @POST
    @Consumes("application/protobuf")
    public Response postAWidget(Widget widget) {
        StringBuilder builder = new StringBuilder("Saving Widget \n");
        builder.append("ID: ").append(widget.getId()).append("\n");
        builder.append("Name: ").append(widget.getName()).append("\n");
        return Response.created(null).entity(builder.toString()).build();
    }
}