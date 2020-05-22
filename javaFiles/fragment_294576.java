@Component
@Path("/")
public class AppResource {
    @Autowired private App1 app1;
    @Autowired private App2 app2;
    @Autowired private App3 app3;

    @Path("")
    public App1 app1Resource() {
        return app1;
    }

    @Path("/v1.0/app/request")
    public App2 app2Resource() {
        return app2;
    }

    @Path("/v1.0/app/response")
    public App3 app3Resource() {
        return app3;
    }
}