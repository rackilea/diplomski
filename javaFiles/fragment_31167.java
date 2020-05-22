package com.mashosoft.backEndTest.security.config;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder( encoder() );
        daoAuthenticationProvider.setUserDetailsService( userDetailsService );
        return  daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) {
        authManagerBuilder.authenticationProvider( authenticationProvider() );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
        .and()
        .addFilter( new JwtAuthorizationFilter( authenticationManager(),restAuthenticationEntryPoint,userRepository ) );
        http.exceptionHandling().authenticationEntryPoint( restAuthenticationEntryPoint );
        http.authorizeRequests()
            .antMatchers( HttpMethod.POST,"/Auth/login**" ).permitAll()
            .antMatchers( HttpMethod.POST,"/Auth/signup**" ).permitAll()
            .anyRequest().authenticated();
    }
}