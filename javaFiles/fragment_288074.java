@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD, PARAMETER, FIELD})
public @interface ServiceProducer {

}

public class ServiceProducerImpl {

    @Produces
    @ServiceProducer
    public ResteasyWebTarget getClient() {
        String patApi = "http://localhost:5000";
        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target(UriBuilder.fromPath(patApi));
            return target;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}