@Path("/")
@RequestScoped
public class Resource {

    private Storage storage;

    @Inject
    public Resource(Storage storage) {
        this.storage = storage;
    }

    @GET
    @Path("get/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGuid(@PathParam("name") String name) {
        return storage.get(name);
    }
}