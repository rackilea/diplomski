@Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(accountDetailsService)
                    .passwordEncoder(passwordEncoder)
                    .and()
                    .authenticationProvider(authenticationProvider())
                    .jdbcAuthentication()
                    .dataSource(dataSource);
        }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(accountDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }