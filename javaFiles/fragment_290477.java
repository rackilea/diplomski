@Override
protected void configure(HttpSecurity http) throws Exception
{
    http
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll()
            .and()
        .logout().permitAll()
            .and()
        .csrf().disable();
}