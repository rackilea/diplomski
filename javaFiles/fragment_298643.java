@Bean
public RegistrationBean jwtAuthFilterRegister(JwtAuthenticationFilter filter) {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
    registrationBean.setEnabled(false);
    return registrationBean;
}