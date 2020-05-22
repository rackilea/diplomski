@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
                .antMatchers("/employee/me").authenticated()
                .antMatchers("/**").permitAll();
}