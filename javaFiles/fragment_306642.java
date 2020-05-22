@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Extract and validate the API key from the request
        String apiKey = requestContext.getHeaderString("API-Key");
        ...
    }
}