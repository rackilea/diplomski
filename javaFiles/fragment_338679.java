@Path("/auto")
public class Rest {

    @POST
    @Path("/start")
    public String start() {
        ...
    }

    @POST
    @Path("/stop")
    public String stop() {
        ...
    }
}