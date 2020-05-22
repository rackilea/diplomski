@Path("/some/path")
@RequestScoped
public class MyResource
{
    private final MySingletonDao mySingletonDao;

    @Inject
    public MyResource(MySingletonDao mySingletonDao)
    {
        this.mySingletonDao = mySingletonDao;
    }

    @POST
    @Produces("application/json")
    public String post() throws Exception
    {
            // ... implementation goes here ...
    }
}