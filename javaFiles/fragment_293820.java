http
    .authorizeRequests()
        .antMatchers("/register").permitAll()
        .and()
    .authorizeRequests()
        .antMatchers("/console/**").permitAll();