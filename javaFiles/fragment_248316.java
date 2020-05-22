http
        // Same as before
        .httpBasic()
        .and()
        .authorizeRequests()
            .antMatchers("/api/confirm/**").permitAll()
            .antMatchers("/api/version").permitAll()
            .antMatchers("/api/**").hasRole("API")
            .anyRequest().permitAll();
        // Same as before