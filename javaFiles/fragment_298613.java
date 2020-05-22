@Bean
public FilterRegistrationBean corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    CorsConfiguration samlCorsConfig = new CorsConfiguration();
    samlCorsConfig.addAllowedOrigin(CorsConfiguration.ALL);
    samlCorsConfig.addAllowedHeader(CorsConfiguration.ALL);
    samlCorsConfig.addAllowedMethod(CorsConfiguration.ALL);
    samlCorsConfig.setMaxAge(600L);
    source.registerCorsConfiguration("/saml/**", samlCorsConfig);

    CorsConfiguration apiCorsConfig = new CorsConfiguration();
    apiCorsConfig.addAllowedOrigin("https://example.com");
    apiCorsConfig.addAllowedHeader(CorsConfiguration.ALL);
    apiCorsConfig.addAllowedMethod(CorsConfiguration.ALL);
    apiCorsConfig.setMaxAge(600L);
    source.registerCorsConfiguration("/**", apiCorsConfig);

    FilterRegistrationBean filterRegistrationBean =
        new FilterRegistrationBean<>(new CorsFilter(source));
    filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return filterRegistrationBean;
}