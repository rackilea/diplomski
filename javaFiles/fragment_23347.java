@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/petclinic/")
                .usernameParameter("j_username") // default is username
                .passwordParameter("j_password") // default is password
                .loginProcessingUrl("/j_spring_security_check") // default is /login with an HTTP post 
                .failureUrl("/login")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/index.jsp")
                .and()
            .authorizeRequests()
                .antMatchers("/**").hasRole("ROLE_ADMIN")
                .antMatchers("/j_spring_security_check").permitAll()
                .and()
            .userDetailsService(userDetailsService);
    }
}