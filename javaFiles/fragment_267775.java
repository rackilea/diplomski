@Logged
@Provider
public class ResponseLoggingFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, 
                       ContainerResponseContext responseContext) throws IOException {
        // Use the ContainerRequestContext to extract information from the HTTP request
        // Use the ContainerResponseContext to extract information from the HTTP response
    }
}