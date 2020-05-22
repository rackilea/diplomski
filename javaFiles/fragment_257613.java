@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private String tokenKey = "some token goes here";
@Autowired
private UserDetailsServiceImpl userDetailsServiceImpl;
@Autowired private CustomTokenBasedRememberMeService tokenBasedRememberMeService;
@Autowired private RememberMeAuthenticationProvider rememberMeAuthenticationProvider;

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests()
            .antMatchers("/api/**").access("hasRole('ROLE_USER')")
            .and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/login")
            .failureUrl("/login?error")
            .usernameParameter("username").passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/login?logout").and().rememberMe().rememberMeServices(tokenBasedRememberMeService).and().exceptionHandling()
            .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());;
    auth.authenticationProvider(rememberMeAuthenticationProvider);
}

@Bean
@Override public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
@Bean public CustomTokenBasedRememberMeService tokenBasedRememberMeService(){
    CustomTokenBasedRememberMeService service = new CustomTokenBasedRememberMeService(tokenKey, userDetailsServiceImpl);
    service.setAlwaysRemember(true);
    service.setCookieName("at");
    return service;
}
@Bean
RememberMeAuthenticationProvider rememberMeAuthenticationProvider(){
    return new RememberMeAuthenticationProvider(tokenKey);
}
@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
}
}