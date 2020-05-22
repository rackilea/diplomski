@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Context
    private UriInfo info;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        ...
    }
}