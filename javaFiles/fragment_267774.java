@Logged
@Provider
public class RequestLoggingFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Use the ContainerRequestContext to extract information from the HTTP request
        // Information such as the URI, headers and HTTP entity are available
    }
}