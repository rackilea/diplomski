public class AuthFilter implements ContainerRequestFilter {

    // Exception thrown if user is unauthorized.
    private final static WebApplicationException unauthorized =
       new WebApplicationException(
           Response.status(Status.UNAUTHORIZED)
                   .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"realm\"")
                   .entity("Page requires login.").build());

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) 
            throws WebApplicationException {

        // Automatically allow certain requests.
        String method = containerRequest.getMethod();
        String path = containerRequest.getPath(true);
        if (method.equals("GET") && path.equals("application.wadl"))
            return containerRequest;

        // Get the authentication passed in HTTP headers parameters
        String auth = containerRequest.getHeaderValue("authorization");
        if (auth == null)
            throw unauthorized;

        auth = auth.replaceFirst("[Bb]asic ", "");
        String userColonPass = Base64.base64Decode(auth);

        if (!userColonPass.equals("admin:toHah1ooMeor6Oht"))
            throw unauthorized;

        return containerRequest;
    }
}