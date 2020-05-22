@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
     .antMatchers("/healthcheck").permitAll()
     .antMatchers("/**").authenticated().and().httpBasic();
}