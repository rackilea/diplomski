@Override
public void configure(final HttpSecurity http) throws Exception {
    http
    .authorizeRequests()
    .antMatchers("/api/v1/signup").permitAll()  //context path here
    .anyRequest().authenticated();
}