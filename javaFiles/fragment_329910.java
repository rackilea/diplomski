@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${security.enable-csrf}")
    private boolean csrfEnabled;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);

       if(!csrfEnabled)
       {
         http.csrf().disable();
       }
    }
}