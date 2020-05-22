@Path("test")
public class MyResource {

    @GET 
    @MixIn // <== Here is important part
    @Produces(MediaType.APPLICATION_JSON )
    public Response  getShortName() {
        return Response.ok(demoObj()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON )
    public Response  postLongName() {
        return Response.ok(demoObj()).build();
    }
}