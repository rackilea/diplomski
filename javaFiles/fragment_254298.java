@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilter(casAuthenticationFilter())
            .csrf().disable()
            .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
            .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))