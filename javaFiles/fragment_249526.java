@POST
@Path("/{what}")
@Consumes("application/json")
@Produces("application/json")
public String v2(String json, @PathParameter("what") String what){
   return "The path "+what+" does not exist.";
}