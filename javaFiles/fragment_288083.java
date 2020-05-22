@POST
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response getData(@FormParam("one") String one,@FormParam("two") String two,@FormParam("three") String three) {
    if(one.isEmpty() || two.isEmpty() || three.isEmpty()) {
        logger.error("Missing params for getData");
        throw new WebApplicationException(501);
    }
    return Response.ok();
}