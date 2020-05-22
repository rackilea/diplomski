@GET
@Path("/myFunc")
public Response myFunc(@QueryParam("input") String input) {
    if (! input.startsWith("123")) {
        return Response.status(Status.BAD_REQUEST)
                       .entity("Usage error: input must start with '123'")
                       .build();
    }
    return Response.ok("Success").build();
}