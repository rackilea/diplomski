@Consumes("application/json")
public Response post(HelloWorld helloWorld) {
    String name = helloWorld.getName();     // should == "whatever"

    return Response.ok(helloWorld).build(); // we can also return objects
}