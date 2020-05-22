@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/sites")
          .failureUrl("/login")
          .successHandler(yourSuccessHandlerBean) // autowired or defined below
          .and()
        .logout()
          .permitAll()
          .and()
  }