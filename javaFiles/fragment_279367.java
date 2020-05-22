@GET
@Produced(MediaType.APPLICATION_JSON)
public Response getResponse() {
    ...
    return Response.status(Response.Status.OK)
                    .entity(entity)
                    .type(MediaType.APPLICATION_JSON).build();
}