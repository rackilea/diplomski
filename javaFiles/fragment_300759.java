protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .httpBasic()
            .and()
        .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
}