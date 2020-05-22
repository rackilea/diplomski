@Named
@Path("/myresource")
public class MyResourceImpl {

    @Context
    private SecurityContext securityContext;

    @RolesAllowed("ROLE_superadmin")
    @GET
    @Produces(MediaType.TEXT_XML)
    public String get() {
        return securityContext.getUserPrincipal().getName();
    }
}