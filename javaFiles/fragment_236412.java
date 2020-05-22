public class GoogleAuthCodeInstalledApp extends AuthorizationCodeInstalledApp {

    public GoogleAuthCodeInstalledApp(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
        super(flow, receiver);
    }

    @Override
    public Credential authorize(String userId) throws IOException {
        try {
            Credential credential = getFlow().loadCredential(userId);
            if (credential != null
                    && (credential.getRefreshToken() != null
                    || credential.getExpiresInSeconds() == null
                    || credential.getExpiresInSeconds() > 60)) {
                return credential;
            }
            // open in browser
            String redirectUri = getReceiver().getRedirectUri();
            AuthorizationCodeRequestUrl authorizationUrl
                    = getFlow().newAuthorizationUrl().setRedirectUri(redirectUri);
            onAuthorization(authorizationUrl);
            // receive authorization code and exchange it for an access token
            String code = getReceiver().waitForCode();
            GoogleTokenResponse response = (GoogleTokenResponse) getFlow().newTokenRequest(code).setRedirectUri(redirectUri).execute();
            System.out.println(response.getIdToken()); //YES, THIS IS THE ID TOKEN!!!
            // store credential and return it
            return getFlow().createAndStoreCredential(response, userId);
        } finally {
            getReceiver().stop();
        }
    }

}