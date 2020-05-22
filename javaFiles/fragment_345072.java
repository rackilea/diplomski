@GET
@Path("/foo")
@Produces("text/plain")
public String methodImCalling(@DefaultValue("All") 
                              @QueryParam(value = "item") 
                              final List<String> item) {
   return "values are " + item;
}