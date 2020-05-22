public class MyEndpointsUnix {
    @GET
    @Path("/dateAsUnix")
    public Foo getDateAsUnix() {
        return new UnixFoo(new Foo());
    }
}