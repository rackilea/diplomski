@Bean
public JdbcUserDetailsManager userDetailsManager() {
    JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
    manager.setDataSource(dataSource);
    manager.setUsersByUsernameQuery(
        "select username,password,enabled from users where username=?");
    manager.setAuthoritiesByUsernameQuery(
        "select username, role from user_roles where username=?");
    manager.setRolePrefix("ROLE_");
    return manager;
}

@Autowired
public void configAuthentication(AuthenticationManagerBuilder builder)
        throws Exception {

    builder.userDetailsService(userDetailsManager());
}