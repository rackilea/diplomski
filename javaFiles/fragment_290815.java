@Autowired
public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)/*.passwordEncoder(new BCryptPasswordEncoder())*/;
}

@Override
protected void configure(HttpSecurity http) throws Exception {

     http.addFilterAfter(csrfTokenFilter, CsrfFilter.class);

     http.authorizeRequests().antMatchers("/rest/**").access("hasRole('ROLE_REST_USER')")
        .and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
        .successHandler(loginSuccessHandler)
        .failureHandler(authenticationFailureHandler).permitAll()
        .and().logout().invalidateHttpSession(true).addLogoutHandler(logoutSuccessHandler).permitAll()
        .and().exceptionHandling().accessDeniedPage("/403")
        .and().csrf();
}