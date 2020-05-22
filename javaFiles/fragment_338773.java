@ApplicationScoped
@Path("/app")
public class MyController {
    @Inject
    @ConfigurationValue("database.name")
    private String name;

    @Inject
    private Configuration configuration;
}