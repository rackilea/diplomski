@Override
    public void configure(HttpSecurity http) throws Exception {
        http
        ...
        .and()
            .authorizeRequests()
            .antMatchers("my-path/**").hasAuthority("RELEVANT_AUTHORITY")
        .and()
            .httpBasic()
        .and()
            .authenticationProvider(new ClusterInternalAuthenticationProvider());
    }