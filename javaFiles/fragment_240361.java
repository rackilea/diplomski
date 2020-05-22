@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
protected class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .httpBasic();

        http
            .authorizeRequests()
                .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
                .anyRequest().authenticated()
                .and()
            .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on
        http
            .sessionManagement()
                .maximumSessions(1)
                    .maxSessionsPreventsLogin(true)
                    .sessionRegistry(sessionRegistry());
    }
}

// Work around https://jira.spring.io/browse/SEC-2855
@Bean
public SessionRegistry sessionRegistry() {
    SessionRegistry sessionRegistry = new SessionRegistryImpl();
    return sessionRegistry;
}

// Register HttpSessionEventPublisher
@Bean
public static ServletListenerRegistrationBean httpSessionEventPublisher() {
    return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
}