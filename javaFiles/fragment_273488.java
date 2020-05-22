protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable(); // TODO. Enable this!!!
    http.authorizeRequests()
    .and()
    .formLogin()
    .loginPage("http://oauth.web.com/oauth/authorize?response_type=code&client_id=webclient&redirect_uri=http://web.com") // manually defining page to login
    //.failureUrl("/login?error") // manually defining page for login error
    .usernameParameter("email")
    .permitAll()   
    .and()
    .logout()
    //.logoutUrl("/logout")
    .logoutSuccessUrl("/")
    .permitAll();
}