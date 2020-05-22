@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        // here we have access to headers:
        String authorizationHeader = context.getHeaderString("Authorization");

        // and, thanks to injected resourceInfo, to annotations:
        RolesAllowed annotation = resourceInfo
                .getResourceClass() // or getResourceMethod(), I've used both
                    .getAnnotation(RolesAllowed.class);
        // and, finally, to the roles (after a null-check)
        String[] roles = annotation.value();

        // then you can authenticate and authorize everything on your own using any method (I’ve used Basic Auth and JWT)
        // and, if something fails, you can abort the request:
        if (!isAuthenticated) {
            context.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        } else if (!isAuthorized) {
            context.abortWith(Response.status(Response.Status.FORBIDDEN).build());
        }           
    }
    ...
}