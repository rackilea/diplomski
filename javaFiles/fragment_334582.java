@Path("/hello")
public class Hello {

    @POST
    @Path(value = "/ids")
    public String ids(@HeaderParam("id") final String id) throws JSONException {
        return getResults("select * from " + id);
    }
}