@Path("/health")
public class HealthChecker {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response check() {
        return Response.status(Response.Status.OK)
            .entity("{\"status\":\"UP\"}")
            .build();
    }
}