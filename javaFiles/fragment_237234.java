@Path("yell/{date}/{articleName}")
public class RestService {
    @GET
    @Produces("application/json")
    public String getJson(@PathParam("date") String date, 
      @PathParam("articleName") String articleName) {
        return "{ \"content\" : \"// TODO\" }";
    }
}