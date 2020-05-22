public class MySecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired(name="userDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws
            Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       ....
    }

    @Bean(name="authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /* not working:
    public AuthenticationManager authenticationManager() {  ...  }
    */

    @Bean(name="userDetailsService")
    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new MyUserDetailsService();
    }
    // not working:  UserDetailsService userDetailsService() { ... }
}