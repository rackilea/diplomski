@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
            .antMatchers("/**").hasAnyRole("ADMIN","USER")
          .and()
          .httpBasic()
        ;
    }