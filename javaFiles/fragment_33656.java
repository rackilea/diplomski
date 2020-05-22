@Override
public void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http
            .antMatcher("/api/**").authorizeRequests()
            .antMatchers("/api/v1.0/users").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(STATELESS); 
    // @formatter:on
}