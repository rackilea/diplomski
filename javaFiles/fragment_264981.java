@Path("/test")
public class TestResource {

    @GET
    @Produces("text/plain")
    public String getTestResults() {

        return runTests();
    }

    private String runTests() {
        ...
    }

}