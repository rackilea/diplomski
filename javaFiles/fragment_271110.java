@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    Environment environment;

    public WebSecurity(Environment environment) {
        this.environment = environment;
    }

    @Override
        public void configure(WebSecurity web) throws Exception {
            web
              .ignoring()
              .antMatchers(HttpMethod.GET,"users-ws/users/status/check")
              .antMatchers(HttpMethod.POST,"users-ws/users/h2-console/**")
              .antMatchers(HttpMethod.POST,"users-ws/users/createUser")
              .antMatchers(HttpMethod.POST,"users-ws/users/login");

            //completely bypass the Spring Security Filter Chain.
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new AuthorizationFilter(authenticationManager(),environment));
    }
}