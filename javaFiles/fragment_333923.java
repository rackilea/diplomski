@Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/","/static/**").permitAll()
                    .mvcMatchers("/admin").access("hasAuthority('ROLE_ADMIN')")
                    .mvcMatchers("/employees").access("hasAuthority('ROLE_STAFF')")
                    .anyRequest().authenticated()
                    .and()
                .httpBasic()
                    .and()
                  .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                    .logout().logoutSuccessUrl("/")
                    .and()
                .headers().contentSecurityPolicy("default-src 'self' " +
                                                 "https://ajax.googleapis.com " +
                                                 "https://cdnjs.cloudfare.com " +
                                                 "style-src 'self' 'unsafe-inline' ");


    }