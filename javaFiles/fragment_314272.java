http.authorizeRequests()
            .antMatchers("/resources/**", "/signup", "/about").permitAll();

    for (Matcher matcher : matchers) {
        http.authorizeRequests().antMatchers(matcher.name).access(matcher.roleInfo);
    }
    http.authorizeRequests().anyRequest().authenticated()
            .and()
                    // ...
            .formLogin();