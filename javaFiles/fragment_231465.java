@Authorize
public Response getUser() {
    // Do something
}

@Provider
@Authorize
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {

        MultivauledMap<String, String> headers - requestContext.getHeaders();
        ...
        if (!authorized) {
            throw new NotAuthorizedException();
        }
    }
}