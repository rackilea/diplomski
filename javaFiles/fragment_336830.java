@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
           .dataSource({datasource})
           .usersByUsernameQuery("select username,password,1 "+ "from xxx " + "where username = ?")
           .authoritiesByUsernameQuery("select username, role "+ "from xxx " + "where username = ?")
}