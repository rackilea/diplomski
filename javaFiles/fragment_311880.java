@Configuration
@WebSecurity // optional?
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired 
    private UserDetailsService userService; // can be replaced by whatever service implements UserDetailsService

    @Bean
    public CustomDaoAuthenticationProvider daoAuthenticationProvider() {
        CustomDaoAuthenticationProvider authenticationProvider = new CustomDaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        System.out.println("Using my custom DaoAuthenticationProvider");
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    // ...

}