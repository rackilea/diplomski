@Path("/myresource")
public interface MyResource {

    @GET
    @Produces(MediaType.TEXT_XML)
    String get();
}

@Named
public class MyResourceImpl implements MyResource {

    @Context
    private SecurityContext securityContext;

    @Override
    @RolesAllowed("ROLE_user")
    public String get() {
        return securityContext.getUserPrincipal().getName();
    }
}