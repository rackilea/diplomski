@Override
protected void configure(final HttpSecurity http) throws Exception
{
    http
    .authorizeRequests()
        .antMatchers("/welcome","/inventory/**","/sales/**").access("hasRole('USER')")
    .and().exceptionHandling()
        .accessDeniedPage("/403")
    .and().formLogin()
    .and().logout()
        .logoutSuccessUrl("/login?logout=true")
        .invalidateHttpSession(true)
    .and()
        .csrf()
            .disable();
}