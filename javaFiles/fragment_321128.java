@GET
@Path("/testGet")
@Produces("application/json")
public Response testGet() {
    String json = //Create JSON String
    return Response.ok(json, MediaType.APPLICATION_JSON).build();
}