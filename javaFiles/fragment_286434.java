@Path("")
public class TestService {

    @GET
    @Path("/v1/test1/list")
    public Response getTest1() {
        ...
    }

    @GET
    @Path("/v1/test2/list")
    public Response getTest2() {
        ...
    }
}