@Override
protected void configure(HttpSecurity http) throws Exception {
    http.headers()
        .frameOptions().sameOrigin()
    .and().formLogin()
        .loginPage(RequestMappings.LOGIN)
        .failureHandler(failureHandler())
        .successForwardUrl("/")
        .permitAll()
        .loginProcessingUrl("/login")
    .and().logout()
        .logoutSuccessUrl("/login?logout")
    .and().authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers(RequestMappings.CHANGE_PASSWORD).permitAll()
        .anyRequest().authenticated()
    .and().csrf()
        .csrfTokenRepository(csrfTokenRepository())
    .and().addFilterAfter(csrfHeaderFilter(), SessionManagementFilter.class);
}