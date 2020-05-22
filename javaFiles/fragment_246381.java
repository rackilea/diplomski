http
    .formLogin()
        // NOTE: added .html suffix
        .loginPage("/login.html")
        .permitAll()
        .and()
    .authorizeRequests()
        .anyRequest().authenticated();