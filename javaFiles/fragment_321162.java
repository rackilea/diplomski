protected void configure(HttpSecurity http) throws Exception {

        http.
        authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/rest/**").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/landing").hasAnyAuthority("ADMIN","EMPLOYEE")
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/employee/**").hasAuthority("EMPLOYEE")
            .anyRequest()
            .authenticated().and()
            .formLogin()
            .loginPage("/login").failureUrl("/login?error=true")
            .defaultSuccessUrl("/landing")
            .usernameParameter("email")
            .passwordParameter("password")
            .and().logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login").and().exceptionHandling()
            .accessDeniedPage("/access-denied");

    }