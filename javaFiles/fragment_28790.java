protected void configure(HttpSecurity http)throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll() // This will be your home screen URL
            .antMatchers("/css/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .defaultSuccessUrl("/postloginscreen") //configure screen after login success
            .loginPage("/login")
            .permitAll()
            .and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
    }