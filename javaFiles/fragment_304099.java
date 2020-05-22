...
@Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.logout().logoutSuccessUrl("/home")
                .and()
                .authorizeRequests()
                .antMatchers("/**").hasAuthority("ROLE_USER");
    }
...