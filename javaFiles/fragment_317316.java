@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/homepage**").hasRole("USER")
        .antMatchers("/index**").permitAll()
        .antMatchers("/login**").permitAll()
        .and()
        .formLogin();
        //.loginPage( "/login" )
        //.loginProcessingUrl( "/login" )
        //.defaultSuccessUrl( "/index" );
    http.csrf().disable();
}