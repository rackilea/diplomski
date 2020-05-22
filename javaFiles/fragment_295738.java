@Path(...)
public class MyResource {

    @Context
    private Application app;

    @GET
    @Path(...)
    public String someMethod() {
        String directory = app.getProperties().get("directory");
        ...
    }
}