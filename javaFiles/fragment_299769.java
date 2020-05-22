@GET
@Path("{blah}/{blahh}")
public String getAnything(@PathParam("blah") String blah, 
                          @PathParam("blahh") String blahh,
                          @Context UriInfo uriInfo) {
  return "<a href='" + uriInfo.getAbsolutePath() + "'>Hi</a>";
}