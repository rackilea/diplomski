@Override
public void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin().usernameParameter("email_id").passwordParameter("password").permitAll();
}