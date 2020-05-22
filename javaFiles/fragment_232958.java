@Path("/your_class")
public class YourClass {
    [...]
    @POST
    @Path("/your_method")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Object> yourMethod(String input){
        [...]
        return new ArrayList<Object>();
    }
}