http
    .formLogin()
        // NOTE removed .loginPage("/login")
        .permitAll()
        .and()
    .authorizeRequests()
        .anyRequest().authenticated();