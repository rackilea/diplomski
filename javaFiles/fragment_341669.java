@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

    private MetricRegistry service;

    public HelloResource(MetricRegistry service) {
        this.service = service;
    }

    @GET
    public String hello() {

        Timer timer = service.timer("test");

        try(Context t = timer.time()) {
            return "Hello World";
        }

    }


    @GET
    @Path("/test2")
    public void test(@Valid @CustomValidation @QueryParam("arg") String test) {
        System.out.println(test);
    }
}