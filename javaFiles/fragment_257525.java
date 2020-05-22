package example;

import org.restlet.*;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.*;

public class ExampleApp extends Application {

    private ChallengeAuthenticator authenticatior;

    private ChallengeAuthenticator createAuthenticator() {
        Context context = getContext();
        boolean optional = true;
        ChallengeScheme challengeScheme = ChallengeScheme.HTTP_BASIC;
        String realm = "Example site";

        // MapVerifier isn't very secure; see docs for alternatives
        MapVerifier verifier = new MapVerifier();
        verifier.getLocalSecrets().put("user", "password".toCharArray());

        ChallengeAuthenticator auth = new ChallengeAuthenticator(context, optional, challengeScheme, realm, verifier) {
            @Override
            protected boolean authenticate(Request request, Response response) {
                if (request.getChallengeResponse() == null) {
                    return false;
                } else {
                    return super.authenticate(request, response);
                }
            }
        };

        return auth;
    }

    @Override
    public Restlet createInboundRoot() {
        this.authenticatior = createAuthenticator();

        Router router = new Router();
        router.attach("/user", UserResource.class);

        authenticatior.setNext(router);
        return authenticatior;
    }

    public boolean authenticate(Request request, Response response) {
        if (!request.getClientInfo().isAuthenticated()) {
            authenticatior.challenge(response, false);
            return false;
        }
        return true;
    }

}