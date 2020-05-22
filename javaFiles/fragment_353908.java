@Path("/myresource")
public interface MyResource {

    @Context 
    public void setSecurityContext(Security securityContext); 

    @GET
    @Produces(MediaType.TEXT_XML)
    String get();
}

@Named
public class MyResourceImpl implements MyResource {

    private SecurityContext securityContext;

    @Override
    public void setSecurityContext(Security securityContext) { 
        this.securityContext = securityContext
    }

    @Override
    @RolesAllowed("ROLE_user")
    public String get() {
        return securityContext.getUserPrincipal().getName();
    }
}