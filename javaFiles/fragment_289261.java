@Override
public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
    authorizationServerSecurityConfigurer
            .authenticationEntryPoint(authenticationEntryPoint)
            .addTokenEndpointAuthenticationFilter(customBasicAuthenticationFilter);
}