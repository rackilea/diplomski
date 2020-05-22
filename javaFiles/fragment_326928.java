@Override
protected void configure(HttpSecurity http) throws Exception {

    http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic()
            .and()
            .logout().clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 
            .logoutSuccessUrl("/test") 
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true);


}