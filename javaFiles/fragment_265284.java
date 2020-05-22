@GET
@Path("/sumPost")
@Produces(MediaType.TEXT_PLAIN)
public String sumPost(@QueryParam("x") int x,
                      @QueryParam("y") int y) {
}