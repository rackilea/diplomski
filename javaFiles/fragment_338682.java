@Path("/auto/status")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Rest {

    @PUT
    public String changeStatus(Status status) {
        ...
    }

    @GET
    public Status getStatus() {
        ...
    }
}