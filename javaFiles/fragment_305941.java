@Override
protected void configure(HttpSecurity http) throws Exception {          
    http
        .antMatcher("/console/**") // Add this
        .httpBasic().and()
        .exceptionHandling().authenticationEntryPoint(consoleAuthenticationEntryPoint).and()
        .authorizeRequests().antMatchers("/console/**").authenticated()
        .antMatchers(HttpMethod.GET,
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js").permitAll()
        .anyRequest().authenticated().and()
        .formLogin().defaultSuccessUrl("/console/home")
        .loginPage("/console/login").permitAll().and()
        .logout().permitAll().and() // Make sure to use .and() to add the .csrf()
        .csrf().disable();
}