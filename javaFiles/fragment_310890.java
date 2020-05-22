@Override
public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    AuthenticationManager authenticationManager = authenticationManagerProvider.authenticationManagerBean();
    DefaultOAuth2RequestFactory oAuth2RequestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);
    CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManager, oAuth2RequestFactory);

    security.tokenKeyAccess("permitAll()") //
        .checkTokenAccess("isAuthenticated()") //
        .allowFormAuthenticationForClients() //
        .addTokenEndpointAuthenticationFilter(filter);
}