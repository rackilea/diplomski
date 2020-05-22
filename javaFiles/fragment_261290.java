@Bean
public X509AuthenticationConverter x509AuthenticationConverter() {
    return new X509AuthenticationConverter();
}

@Bean
public AuthenticationWebFilter x509AuthenticationWebFilter(ReactiveAuthenticationManager reactiveAuthenticationManager,
                                                          X509AuthenticationConverter x509AuthenticationConverter) {
    AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(reactiveAuthenticationManager);
    authenticationWebFilter.setAuthenticationConverter(x509AuthenticationConverter);
    return authenticationWebFilter;
}