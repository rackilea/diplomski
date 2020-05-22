@Component
@Configuration
public class AppConfig
{
    @Value("${accessTokenEndpointUrl}") String accessTokenUri;
    @Value("${clientId}") String clientId;
    @Value("${clientSecret}") String clientSecret;
    @Value("${policyAdminUserName}") String username;
    @Value("${policyAdminUserPassword}") String password;

    @Bean
    public OAuth2RestTemplate myPolicyAdmin(ResourceOwnerPasswordResourceDetails details)
    {
        return new OAuth2RestTemplate(details);
    }

    @Bean
    public ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails()
    {
         ResourceOwnerPasswordResourceDetails bean = new ResourceOwnerPasswordResourceDetails();
         bean.setAccessTokenUri(accessTokenUri);
         bean.setClientId(clientId);
         bean.setClientSecret(clientSecret);
         bean.setUsername(username);
         bean.setPassword(password);         
         return bean;
    }
}