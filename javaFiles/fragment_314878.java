@Path("generic")
@javax.enterprise.context.RequestScoped
public class GenericResource 
{
    @Context
    private UriInfo context;

    @Inject
    TestBean testBean;

    public GenericResource() {}

    @GET
    @Produces("application/json")
    public String getXml() {
        // TODO return proper representation object
        return testBean.getValue();
    }
}