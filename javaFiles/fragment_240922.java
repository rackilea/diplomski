@Path("test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

    private static final Logger log = Logger.getLogger(HelloResource.class);

    @POST
    @Path("/test")
    public Response test(String body) {
        Map<String, String> tmp = new HashMap<>();
        tmp.put("test", "value");
        return Response.ok(tmp).build();
    }

}