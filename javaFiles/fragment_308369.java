protected void configure(HttpSecurity http) throws Exception {
    http
        // disabling csrf here, you should enable it before using in production
        .csrf().disable
        .authorizeRequests()
       // this matcher is working for all GET/POST/... , any URL matching the reg expression
            .antMatchers("/**").permitAll()
}