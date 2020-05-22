@Bean
public FilterRegistrationBean FilterRegistration() {
    FilterRegistrationBean registration = new  FilterRegistrationBean();
    registration.setFilter(filter);
    registration.setOrder(1);
    registration.addUrlPatterns("/app/*");
    return registration;
}