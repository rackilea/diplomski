import com.google.api.services.pubsub.Pubsub;
import com.google.api.services.pubsub.model.PublishRequest;
import com.google.api.services.pubsub.model.PubsubMessage;
public class PubsubManager {
    private static final Logger logger = LoggerFactory.getLogger(PubsubManager.class);
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final Pubsub pubsub = createPubsubClient();

    public static class RetryHttpInitializerWrapper implements HttpRequestInitializer {

        // Intercepts the request for filling in the "Authorization"
        // header field, as well as recovering from certain unsuccessful
        // error codes wherein the Credential must refresh its token for a
        // retry.
        private final GoogleCredential wrappedCredential;

        // A sleeper; you can replace it with a mock in your test.
        private final Sleeper sleeper;

        private RetryHttpInitializerWrapper(GoogleCredential wrappedCredential) {
            this(wrappedCredential, Sleeper.DEFAULT);
        }

        // Use only for testing.
        RetryHttpInitializerWrapper(
                GoogleCredential wrappedCredential, Sleeper sleeper) {
            this.wrappedCredential = Preconditions.checkNotNull(wrappedCredential);
            this.sleeper = sleeper;
        }

        @Override
        public void initialize(HttpRequest request) {
            final HttpUnsuccessfulResponseHandler backoffHandler =
                    new HttpBackOffUnsuccessfulResponseHandler(
                            new ExponentialBackOff())
                            .setSleeper(sleeper);
            request.setInterceptor(wrappedCredential);
            request.setUnsuccessfulResponseHandler(
                    new HttpUnsuccessfulResponseHandler() {
                        @Override
                        public boolean handleResponse(HttpRequest request,
                                                      HttpResponse response,
                                                      boolean supportsRetry)
                                throws IOException {
                            if (wrappedCredential.handleResponse(request,
                                    response,
                                    supportsRetry)) {
                                // If credential decides it can handle it, the
                                // return code or message indicated something
                                // specific to authentication, and no backoff is
                                // desired.
                                return true;
                            } else if (backoffHandler.handleResponse(request,
                                    response,
                                    supportsRetry)) {
                                // Otherwise, we defer to the judgement of our
                                // internal backoff handler.
                                logger.info("Retrying " + request.getUrl());
                                return true;
                            } else {
                                return false;
                            }
                        }
                    });
            request.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(
                    new ExponentialBackOff()).setSleeper(sleeper));
        }
    }

    /**
     * Creates a Cloud Pub/Sub client.
     */
    private static Pubsub createPubsubClient() {
        try {
            HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
            GoogleCredential credential = GoogleCredential.getApplicationDefault();
            HttpRequestInitializer initializer =
                    new RetryHttpInitializerWrapper(credential);
            return new Pubsub.Builder(transport, JSON_FACTORY, initializer).build();
        } catch (IOException | GeneralSecurityException e) {
            logger.error("Could not create Pubsub client: " + e);
        }
        return null;
    }

    /**
     * Publishes the given message to a Cloud Pub/Sub topic.
     */
    public static void publishMessage(String message, String outputTopic) {
        int maxLogMessageLength = 200;
        if (message.length() < maxLogMessageLength) {
            maxLogMessageLength = message.length();
        }
        logger.info("Received ...." + message.substring(0, maxLogMessageLength));

        // Publish message to Pubsub.
        PubsubMessage pubsubMessage = new PubsubMessage();
        pubsubMessage.encodeData(message.getBytes());

        PublishRequest publishRequest = new PublishRequest();
        publishRequest.setMessages(Collections.singletonList(pubsubMessage));
        try {
            pubsub.projects().topics().publish(outputTopic, publishRequest).execute();
        } catch (java.io.IOException e) {
            logger.error("Stuff happened in pubsub: " + e);
        }
    }
}