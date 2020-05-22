public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    //... other methods still the same. below fixed the error
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                 .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }
}