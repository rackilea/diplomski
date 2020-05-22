http.csrf().disable().authorizeRequests()
        .antMatchers("/api/advert/**").hasRole(DEFAULT_ROLE)
        .antMatchers("/api/company/**").hasRole(DEFAULT_ROLE)
        .antMatchers("/api/user/**").hasRole(DEFAULT_ROLE)
        .and().httpBasic()
        .authenticationEntryPoint(authEntryPoint);