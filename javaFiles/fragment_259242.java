@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService myCustomUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
                .dataSource(dataSource)
                .and()
            .userDetailsService(myCustomUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/app/**").hasRole("ADMIN")
                .and()
            .formLogin()
                .loginPage("/index.jsp")
                .defaultSuccessUrl("/app/")
                .failureUrl("/index.jsp")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/index.jsp");
    }

}