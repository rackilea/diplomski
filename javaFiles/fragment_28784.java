protected void configure(HttpSecurity http) throws Exception {
         http
            .formLogin()
            .loginPage("/login")
            .usernameParameter("email")
            .permitAll()
        .and()
            .logout()
            .permitAll();
}