import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value = "/calendar")
public class CalendarResource {

    @GET
    @Path("/{userid}")
    public Response getChecksum(@PathParam("userid") String userid) {
        String checksum = "test"; // do some calculation or fetched cached one
        return checksum;
    }

    @GET
    @Path("/{userid}")
    public Response getCalendar(@PathParam("userid") String userid) {
        String calendar = "test"; // do some calculation or fetched cached one
        return calendar;
    }
}