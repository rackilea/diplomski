@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()authorizeRequests()
                .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll().anyRequest()
                .authenticated();
    }