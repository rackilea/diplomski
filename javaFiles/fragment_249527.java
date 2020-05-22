@POST
@Path("/{what}")
@Consumes("application/json")
@Produces("application/json")
public Response v2(String json, @PathParameter("what") String what){
   return Response.status(Status.NOT_FOUND).entity("The path "+what+" does not exist.");
}