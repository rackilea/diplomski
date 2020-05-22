@Bean
SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http, AuthenticationWebFilter x509AuthenticationWebFilter) {
    return http
            .addFilterAt(x509AuthenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
            //...
            .build();
}