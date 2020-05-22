@Path("/rest")
public class JerseyService {

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("authenticate.svc")
    @Transactional(readOnly = true)
    public Response authenticate(final JSONObject login) throws IOException {
        System.out.println(login.getString("user"));
        System.out.println(login.getString("pwd"));
        //^^^^^^^^^^^^^^^^^
        Response.ResponseBuilder responseBuilder = Response.ok();

        responseBuilder.entity(JsonSerializer.serialize(Status.SUCCESS));

        return responseBuilder.build();
    }
}