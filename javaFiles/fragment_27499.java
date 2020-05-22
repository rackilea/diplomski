http.authorizeRequests().antMatchers("/admin/**")
    .access("hasRole('ROLE_ADMIN')").and().formLogin()
    .loginPage("/login").failureUrl("/login?error")
    .usernameParameter("username")
    .passwordParameter("password")  
    .and().logout().logoutSuccessUrl("/login?logout")
    .and().csrf().disable();
    //.and().exceptionHandling().accessDeniedPage("/403");