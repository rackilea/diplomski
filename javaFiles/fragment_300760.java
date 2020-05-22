http
    .authorizeRequests()
        .anyRequest().authenticated()
        .and()
    .formLogin().failureHandler(new DefaultAuthenticationFailureHandler())
        .and()
    .csrf().disable();   // NOTE: I would recommend enabling CSRF