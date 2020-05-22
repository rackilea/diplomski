@POST
@Path("/sumPost")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String sumPost(@FormParam("x") int x,
                      @FormParam("y") int y) {

}