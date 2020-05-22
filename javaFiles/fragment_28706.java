@Configuration
public class Authorization extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}