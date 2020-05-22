@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired PathLoginAuthenticationEntryPoint loginEntryPoint;

    @Autowired PathUrlAuthenticationFailureHandler loginFailureHandler;

    @Autowired
    PathUrlLogoutSuccessHandler logoutSuccessHandler;


    @Bean
    public PathTokens pathTokens(){
        return new PathTokens(Arrays.asList("customer", "admin"));
    }

    @Autowired
    public void registerGlobalAuthentication(
        AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("customer").password("password").roles("CUSTOMER").and()
            .withUser("admin").password("password").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/", "/signin/**", "/error/**", "/templates/**", "/resources/**", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
           http .csrf().disable()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/customer/**").hasRole("CUSTOMER")
            .and()
            .formLogin()
            .loginProcessingUrl("/j_spring_security_check")
            .usernameParameter("j_username").passwordParameter("j_password")
            .failureHandler(loginFailureHandler);

        http.logout().logoutSuccessHandler(logoutSuccessHandler);
        http.exceptionHandling().authenticationEntryPoint(loginEntryPoint);
        http.exceptionHandling().accessDeniedPage("/accessDenied");
    }
}