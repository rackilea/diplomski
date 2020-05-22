@Override
protected void configure(HttpSecurity http) throws Exception {
   http.csrf().disable().
   antMatcher("/aggregators/**").authorizeRequests()
   .anyRequest().hasRole("USER")
   .and().httpBasic();
}