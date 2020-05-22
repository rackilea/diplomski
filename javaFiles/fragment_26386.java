@Configuration
public class ServerConfig {

    @Bean
    public ServerProperties serverProperties() {
        return new IgnoreUnknownFieldsServerProperties();
    }

    @ConfigurationProperties(prefix = "server", ignoreUnknownFields = true)
    public static class IgnoreUnknownFieldsServerProperties extends ServerProperties {

    }

}