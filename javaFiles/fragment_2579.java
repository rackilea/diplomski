@Path("/example")
public class Welcome {

    @GET
    public String getSomething(
            @QueryParam("p1") String param1, 
            @QueryParam("p2") String param2, 
            @Context HttpServletResponse response) {

        response.addHeader("CustomHeader", "CustomValue");

        return "my awesome response";
    }
}