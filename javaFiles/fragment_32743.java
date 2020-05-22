@Configuration
@ConditionalOnClass(EnableOAuth2Client.class)
@Conditional(OAuth2ClientIdCondition.class)
public class OAuth2RestOperationsConfiguration {

    @Configuration
    @ConditionalOnNotWebApplication
    protected static class SingletonScopedConfiguration {

        @Bean
        @ConfigurationProperties("security.oauth2.client")
        @Primary
        public ClientCredentialsResourceDetails oauth2RemoteResource() {
            ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
            return details;
        }
        ...
    }
    ...
}