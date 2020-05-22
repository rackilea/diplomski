@GET
@Path("retrieve/{uuid}")
public Response retrieveSomething(@PathParam("uuid") String uuid) {
    if(uuid == null || uuid.trim().length() == 0) {
        return Response.serverError().entity("UUID cannot be blank").build();
    }
    Entity entity = service.getById(uuid);
    if(entity == null) {
        return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for UUID: " + uuid).build();
    }
    String json = //convert entity to json
    return Response.ok(json, MediaType.APPLICATION_JSON).build();
}