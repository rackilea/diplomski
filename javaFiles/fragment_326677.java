public class BasicAuthHandler extends AbstractDeadboltHandler {
    public static final String HEADER_PREFIX = "Basic ";
    private static final String AUTHORIZATION = "authorization";
    private static final String WWW_AUTHENTICATE = "WWW-Authenticate";

    @Override
    public Result beforeAuthCheck(final Http.Context context) {
        return basicAuthenticate(context);
    }
    private Result basicAuthenticate(Http.Context context) {
        if (PlayAuthenticate.isLoggedIn(context.session())) {
            // user is logged in
            return null;
        }
        final String authHeader = context.request().getHeader(AUTHORIZATION);
        if (authHeader == null || !authHeader.toLowerCase().startsWith(HEADER_PREFIX.toLowerCase())) {
            return onAuthFailure(context, "Basic authentication header is missing");
        }
        final String auth = authHeader.substring(HEADER_PREFIX.length());
        final byte[] decodedAuth;
        final String[] credentials;
        try {
            decodedAuth = Base64.base64ToByteArray(auth);
            credentials = new String(decodedAuth, "UTF-8").split(":");
        } catch (final IOException e) {
            Logger.error("basicAuthenticate", e);
            return Results.internalServerError();
        }

        if (credentials.length != 2) {
            return onAuthFailure(context, "Could not authenticate with absent password");
        }

        final String username = credentials[0];
        final String password = credentials[1];

        final AuthUser authUser = new AuthUser(password, username);
        final Enum result = AuthProvider.getProvider().loginUser(authUser);

        if ("USER_LOGGED_IN".equals(result.name())) {
            PlayAuthenticate.storeUser(context.session(), authUser);
            return null;
        }
        return onAuthFailure(context, "Authenticate failure");
    }

    @Override
    public Subject getSubject(final Http.Context context) {
        // your implementation
    }

    @Override
    public Result onAuthFailure(final Http.Context context,
                                final String content) { 
        // your error hangling logic
        return super.onAuthFailure(context, content);
    }
}