@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {

        boolean hasAnnotation = false;
        if (resourceInfo.getResourceMethod().isAnnotationPresent(Authenticated.class)
                || resourceInfo.getResourceClass().isAnnotationPresent(Authenticated.class)) {
            hasAnnotation = true;
        }
        if (!hasAnnotation) return;

        // process authentication is annotation is present