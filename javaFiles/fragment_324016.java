@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Config {
    private ImmutableAuthConfig auth = ModifiableAuthConfig.create();

    public AuthConfig getAuth() {
        return auth;
    }
}