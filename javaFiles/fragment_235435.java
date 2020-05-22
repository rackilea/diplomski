@Override
protected void configure(HttpSecurity http) throws Exception {
    // disable session
    http.sessionManagement().disable()
        .authorizeRequests().antMatchers("/").hasAnyRole("Administrator" , "Member")
            .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/dashboard",true)
                .failureUrl("/login?error")
                .successHandler(authenticationSuccessHandler)
            .and()
            .logout()
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/login")
                .logoutSuccessHandler(logoutSuccessHandler)
            .and()
            .csrf().disable();
}