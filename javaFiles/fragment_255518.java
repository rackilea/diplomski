@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Authenticate the user: How the authentications will be performed is up to you
        // If the authentication failed, abort the request with a 401 status code
        // If the authentication succeeded, you know who your user claims to be

        final SecurityContext securityContext = requestContext.getSecurityContext();
        requestContext.setSecurityContext(new SecurityContext() {

            @Override
            public Principal getUserPrincipal() {
                 return new Principal() {
                    @Override
                    public String getName() {
                        // Return the user name here
                        return null;
                    }
                };
            }

            @Override
            public boolean isUserInRole(String role) {
                // Return if the user is in a role
                return true;
            }

            @Override
            public boolean isSecure() {
                return securityContext.isSecure();
            }

            @Override
            public String getAuthenticationScheme() {
                return "Custom";
            }
        });
    }
}