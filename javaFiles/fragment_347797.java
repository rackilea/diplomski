@Override
public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
            .antMatchers("/*/inserir").hasAuthority(ROLE_ULTRA)
            .anyRequest().authenticated()
            .and().formLogin();
}