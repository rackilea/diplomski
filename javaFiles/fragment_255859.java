@Override
protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/services/**").hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint).and()
        .csrf().disable();


    http.addFilterAfter(new CustomFilter(),
            BasicAuthenticationFilter.class);
}