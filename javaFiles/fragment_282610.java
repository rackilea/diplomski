@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/spring_handle_urls/**").authorizeRequests()
            .and() ...
            ;
        }