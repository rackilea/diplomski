@Provider
public class MyContainerRequestFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {
        resourceInfo.getResourceMethod().getDeclaredAnnotations();
    }
}