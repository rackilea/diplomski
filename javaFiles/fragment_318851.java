public class Foursquare extends Controller {

    static final String FOURSQUARE_OAUTH_REQUEST_TOKEN = "http://foursquare.com/oauth/request_token";
    static final String FOURSQUARE_OAUTH_ACCESS_TOKEN = "http://foursquare.com/oauth/access_token";
    static final String FOURSQUARE_OAUTH_AUTHORIZE = "http://foursquare.com/oauth/authorize";
    static final String CONSUMER_KEY = "N4FKW2GFLMU1UGR3DDQYE4IGJQRGID1JFXYPJS3XFLZN3EU6";
    static final String CONSUMER_SECRET = "DDGHBF25J3RJDD4N4QC2CMRF8YMA1CG94OGFRPTY4RQNLMVH";


    // Handle Request for foursquare Authorization
    public static void authorize() throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException {

        oauth.signpost.OAuthProvider provider = new DefaultOAuthProvider(FOURSQUARE_OAUTH_REQUEST_TOKEN, FOURSQUARE_OAUTH_ACCESS_TOKEN,FOURSQUARE_OAUTH_AUTHORIZE);
        oauth.signpost.OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        String authURL;

        authURL = provider.retrieveRequestToken(consumer,"");

        String tokenSecret = consumer.getTokenSecret();
        session.put("secret", tokenSecret);
        redirect(authURL);
    }

    // Handle call back from foursquare after user Accepts
    public static void oauth() throws IOException, OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException {

        oauth.signpost.OAuthProvider provider = new DefaultOAuthProvider(FOURSQUARE_OAUTH_REQUEST_TOKEN, FOURSQUARE_OAUTH_ACCESS_TOKEN,FOURSQUARE_OAUTH_AUTHORIZE);
        oauth.signpost.OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        String secret = session.get("secret");
        String pinCode = params.get("oauth_token");
        consumer.setTokenWithSecret(pinCode, secret);
        provider.retrieveAccessToken(consumer, pinCode);

        // Get the access token and secret
        String token = consumer.getToken();
        String tokenSecret = consumer.getTokenSecret();

        // Set foursquare4j Credentials
        foursquare4j.type.Credentials credentials = new Credentials();
        credentials.setTokenSecret(tokenSecret);
        credentials.setAccessToken(token);

        foursquare4j.oauth.OAuthConsumer newConsumer = new OAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        foursquare4j.oauth.FoursquareOAuthImpl fs = new FoursquareOAuthImpl(newConsumer, credentials);

        try {
            // Get last 50 checkins
            Checkins checkins = fs.history("50", "");

            render(checkins);
        } catch (FoursquareException e) {
            e.printStackTrace();
        }
    }
}