@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    public void registerAuthentication(AuthenticationManagerBuilder auth, Config appConfig) throws Exception {
        auth.inMemoryAuthentication()
            .withUser(appConfig.getString(APIConfig.CONFIG_KEY_MANAGEMENT_USER_NAME))
            .password(appConfig.getString(APIConfig.CONFIG_KEY_MANAGEMENT_USER_PASS))
            .roles(HyperAPIRoles.DEFAULT, HyperAPIRoles.ADMIN);        
    }



    /**
     * Following Multiple HttpSecurity approach:
     * http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#multiple-httpsecurity 
     */
    @Configuration
    @Order(1)
    public static class ManagerEndpointsSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
            .antMatcher("/management/**").authorizeRequests().anyRequest().hasRole(HyperAPIRoles.ADMIN).and()
            .httpBasic();
        }
    }

    /**
     * Following Multiple HttpSecurity approach:
     * http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#multiple-httpsecurity 
     */
    @Configuration
    public static class ResourceEndpointsSecurityConfig extends WebSecurityConfigurerAdapter {        



       @Override
       protected void configure(HttpSecurity http) throws Exception {                  

            http
            //fyi: This adds it to the spring security proxy filter chain
            .addFilterBefore(createBBAuthenticationFilter(), BasicAuthenticationFilter.class)
            ;      
       }
    }
}