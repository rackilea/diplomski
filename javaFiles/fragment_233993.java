@GET
@Path("/getImage/{key}")
@Produces("image/jpeg")
public final Response get(@PathParam("key") String key) {
    return Response.ok()
        .entity(this.context.getResourceAsStream(key))
        .type("image/jpeg")
        .build();
}