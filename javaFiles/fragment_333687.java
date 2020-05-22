@Singleton
@Path("/stuff")
public class SimpleResource {
    private final ManagerImpl manager;

    @Inject
    public SimpleResource(final ManagerImpl manager) {
        this.manager = manager;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public String submitData(@PathParam("id") final String id) {
        String welcomeScreen = manager.getWelcomeScreen();
        return "This is" + welcomeScreen + id;
    }
}