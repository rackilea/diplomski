@Override
protected void configure(HttpSecurity http) throws Exception {

    http.sessionManagement().maximumSessions(1)
            .sessionRegistry(sessionRegistry()).expiredUrl("/");
    http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/security/checkpoint/for/admin/**").hasRole("ADMIN")
            .antMatchers("/rest/users/**").hasRole("ADMIN").anyRequest()
            .authenticated().and().formLogin().loginPage("/")
            .defaultSuccessUrl("/welcome").permitAll().and().logout()
            .logoutUrl("/logout").and()
            .exceptionHandling().accessDeniedPage("/page_403");//this is what you have to do here to get job done.
}