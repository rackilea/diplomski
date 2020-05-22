@Path("/text/{sso}")
public class Do {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String simple(@PathParam("sso") String sso,
            @QueryParam("d") String params) {
        return "Hello Jersey" + params;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String advanced(@PathParam("sso") String sso,
            @QueryParam("d") String params) {
        return "Hello Jersey-----" + params;
    }
}