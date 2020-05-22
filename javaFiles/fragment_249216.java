@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .authorizeRequests()
    .antMatcher("/**").access("hasRole('ROLE_USER')")
    .antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
    ...;
}