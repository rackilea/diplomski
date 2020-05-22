@Value.Modifiable
public interface AuthConfig {
    String domain();
    String clientId();

    @Value.Redacted
    String clientSecret();
}