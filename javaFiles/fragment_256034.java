@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/resources/**", "/signup").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/")
            .and()
            .rememberMe()
            .and()
            .csrf().disable();
}