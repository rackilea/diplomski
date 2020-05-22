public class AuthenticatorWrapper extends Security.Authenticator {

    private final Security.Authenticator authenticator;

    public AuthenticatorWrapper() {
        authenticator = Play.application().injector().instanceOf(Security.Authenticator.class);
    }

    @Override
    public String getUsername(Http.Context ctx) {
        return authenticator.getUsername(ctx);
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return authenticator.onUnauthorized(ctx);
    }
}