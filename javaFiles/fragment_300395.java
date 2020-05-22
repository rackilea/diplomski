public class Utils {  
    @Context UriInfo uriInfo;

    public String test(String s) {
        return s + "=" +uriInfo.getAbsolutePath().toString();
    }
}

@Path("some")
public class SomeResource {  
    @Inject
    Utils utils;

    @GET
    public Response getSomething() {
        return Response.ok(utils.test("Hello")).build();
    }
}

public class JerseyApplication extends ResourceConfig {

    public JerseyApplication() {
        packages("stackoverflow.jersey.test");
        register(new AbstractBinder(){
            @Override
            protected void configure() {
                bind(Utils.class).to(Utils.class);
            }   
        });
    }
}