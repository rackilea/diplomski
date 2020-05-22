@Path("/whatEverILike")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyApi {

    @POST
    public Output hello(Input input) {
        Output response = new Output();
        response.resultValue = "Hello " + input.inputValue;
        return response;
    }
}