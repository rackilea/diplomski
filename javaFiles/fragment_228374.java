@Path("test")
public class TestResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTest() {
        Hello hello = new Hello();
        hello.hello = "world";
        return Response.ok(hello).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postHello(Hello hello) {
        return Response.ok(hello.hello).build();
    }

    public static class Hello {
        public String hello;
    }
}