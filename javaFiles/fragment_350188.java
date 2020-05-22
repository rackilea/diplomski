@Path("/test") // resource path 
public class Test { // changed from class Web, 'cause resource is ./test

    @GET // [GET] ./project/api/test
    // @Path("test/") - path is already given by class path
    public String test() {
        return "it works!"; 
    }

    @GET // [GET] ./project/api/test/foo
    @Path("/foo")
    public String testFoo() {
        return "it works for foo!";
    }

}