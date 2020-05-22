protected void configure(HttpSecurity http) throws Exception {
  http
    .formLogin()
        .loginPage("/login") 
        .permitAll()
        .and()
    .authorizeRequests()
        .anyRequest()
        .authenticated();
}