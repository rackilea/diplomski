@Bean
public DefaultTokenServices tokenServices() {
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setTokenStore(tokenStore());
    tokenServices.setAuthenticationManager(authenticationManager);
    return tokenServices;
}