@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/inner/event/bus");
        http.antMatcher("/inner/service/**").authorizeRequests()
            .antMatchers("/inner/service/**").hasRole("USER")
            .and().formLogin().and().logout().logoutSuccessUrl("/").and().httpBasic();
    }