@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        // some code here
        .tokenEnhancer(tokenEnhancer());
}

@Bean
@Primary
public AuthorizationServerTokenServices tokenServices() {
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    // some code here as well
    tokenServices.setTokenEnhancer(tokenEnhancer());
    return tokenServices;
}

// Beans beans beans

@Bean
public TokenEnhancer tokenEnhancer() {
    return new CustomTokenEnhancer();
}