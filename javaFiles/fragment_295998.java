@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    ...

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients(); // Disable /oauth/token Http Basic Auth
    }

    ...

}