@Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/oauth/token/revokeById/**").permitAll()
                .antMatchers("/tokens/**").permitAll().anyRequest().authenticated().and().formLogin().permitAll().and()
                .csrf().disable();
        // @formatter:on
    }