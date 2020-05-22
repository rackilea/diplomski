@Override
protected void configure(HttpSecurity http) throws Exception {
http
    .authorizeRequests()
     .antMatchers("/home").hasAuthority("USER")
      .antMatchers("/","/**").access("permitAll")
      .anyRequest().authenticated()
      .and()
        .formLogin()
        .and()
    .httpBasic();
}