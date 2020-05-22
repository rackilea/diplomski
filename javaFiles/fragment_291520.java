@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
            .dataSource(dataSource)
            .rolePrefix("ROLE_")
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("SELECT username, password, enabled FROM app_user WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, role FROM app_user_role WHERE username = ?");
}