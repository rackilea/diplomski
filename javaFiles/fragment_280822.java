@Path("/example")
public class MyExampleResourceImpl {

    @POST
    @Path("/")
    public Response postExample(@Valid final Example example) {
        // ....
    }
}