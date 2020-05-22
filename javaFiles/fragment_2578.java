@Path("/example")
public ExampleResource {
    @GET
    public Response getSomething() {
        return Response.ok(/* some entity */).header("CustomHeader", "CustomValue").build();
    }
}