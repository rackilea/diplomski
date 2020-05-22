@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, true"
                    + " from apiclient where username=?")
            .authoritiesByUsernameQuery("select username, role"
                    + " from apiclient where username=?");
}