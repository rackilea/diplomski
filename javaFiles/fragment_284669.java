@Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            // Since we want the protected resources to be accessible in the UI as well we need 
            // session creation to be allowed (it's disabled by default in 2.0.6)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .and()
            .requestMatchers().antMatchers("/photos/**", "/oauth/users/**", "/oauth/clients/**","/me")
        .and()
            .authorizeRequests()
                .antMatchers("/me").access("#oauth2.hasScope('read')")                  
                .antMatchers("/photos").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))")                                        
        ...
    }