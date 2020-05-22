@Component
@Path("/")
public class App1 {
    @Autowired private App2 app2;
    @Autowired private App3 app3;

    @GET
    @Path("/health")
    public Response health() {...}

    @Path("/v1.0/app/request")
    public App2 app2Resource() {
        return app2;
    }

    @Path("/v1.0/app/response")
    public App3 app3Resource() {
        return app3;
    }
}