@Component
public class OAuthConsumerDetailsService implements ConsumerDetailsService {
    final static Logger log = LoggerFactory.getLogger(OAuthConsumerDetailsService.class);

    @Override
    public ConsumerDetails loadConsumerByConsumerKey(String consumerKey) throws OAuthException {
        BaseConsumerDetails cd;
        // NOTE: really lookup the key and secret, for the sample here we just hardcoded
        if ("key".equals(consumerKey)) {
            // allow this oauth request
            cd = new BaseConsumerDetails();
            cd.setConsumerKey(consumerKey);
            cd.setSignatureSecret(new SharedConsumerSecretImpl("secret"));
            cd.setConsumerName("Sample");
            cd.setRequiredToObtainAuthenticatedToken(false); // no token required (0-legged)
            cd.getAuthorities().add(new SimpleGrantedAuthority("ROLE_OAUTH")); // add the ROLE_OAUTH (can add others as well)
            log.info("OAuth check SUCCESS, consumer key: " + consumerKey);
        } else {
            // deny - failed to match
            throw new OAuthException("For this example, key must be 'key'");
        }
        return cd;
    }

}