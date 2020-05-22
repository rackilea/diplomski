@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableWebMvcSecurity // enable spring security and web mvc hooks
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class Application extends WebMvcConfigurerAdapter {
    final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Spring Security

    @Autowired
    @Order(Ordered.HIGHEST_PRECEDENCE + 10)
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void configureSimpleAuthUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and().withUser("user").password("user").roles("USER");
    }

    @Configuration
    @Order(1) // HIGHEST
    public static class OAuthSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        private ZeroLeggedOAuthProviderProcessingFilter zeroLeggedOAuthProviderProcessingFilter;
        @Autowired
        OAuthConsumerDetailsService oauthConsumerDetailsService;
        @Autowired
        OAuthAuthenticationHandler oauthAuthenticationHandler;
        @Autowired
        OAuthProcessingFilterEntryPoint oauthProcessingFilterEntryPoint;
        @Autowired
        OAuthProviderTokenServices oauthProviderTokenServices;
        @PostConstruct
        public void init() {
            zeroLeggedOAuthProviderProcessingFilter = new ZeroLeggedOAuthProviderProcessingFilter(oauthConsumerDetailsService, new InMemoryNonceServices(), oauthProcessingFilterEntryPoint, oauthAuthenticationHandler, oauthProviderTokenServices);
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/oauth/**")
                    .addFilterBefore(zeroLeggedOAuthProviderProcessingFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests().anyRequest().hasRole("OAUTH");
        }
    }

    @Order(45) // LOW
    @Configuration
    public static class BasicAuthConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/basic/**").authorizeRequests().anyRequest().authenticated()
                    .and().httpBasic();
        }
    }

    @Order(67) // LOWEST
    @Configuration
    public static class NoAuthConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
        }
    }

    // OAuth beans

    public static class OAuthProcessingFilterEntryPointImpl extends OAuthProcessingFilterEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            log.info("OAuth FILTER Failure (commence), req=" + request + ", ex=" + authException);
            // Called when there is an OAuth Auth failure, authException may be InsufficientAuthenticationException
            super.commence(request, response, authException);
        }
    }

    @Bean(name = "oauthAuthenticationEntryPoint")
    public OAuthProcessingFilterEntryPoint oauthAuthenticationEntryPoint() {
        return new OAuthProcessingFilterEntryPointImpl();
    }

    @Bean(name = "oauthProviderTokenServices")
    public OAuthProviderTokenServices oauthProviderTokenServices() {
        // NOTE: we don't use the OAuthProviderTokenServices for 0-legged but it cannot be null
        return new InMemoryProviderTokenServices();
    }

    public static class ZeroLeggedOAuthProviderProcessingFilter extends ProtectedResourceProcessingFilter {
        ZeroLeggedOAuthProviderProcessingFilter(OAuthConsumerDetailsService oAuthConsumerDetailsService, OAuthNonceServices oAuthNonceServices, OAuthProcessingFilterEntryPoint oAuthProcessingFilterEntryPoint, OAuthAuthenticationHandler oAuthAuthenticationHandler, OAuthProviderTokenServices oAuthProviderTokenServices) {
            super();
            log.info("CONSTRUCT Zero Legged OAuth provider");
            setAuthenticationEntryPoint(oAuthProcessingFilterEntryPoint);
            setAuthHandler(oAuthAuthenticationHandler);
            setConsumerDetailsService(oAuthConsumerDetailsService);
            setNonceServices(oAuthNonceServices);
            setTokenServices(oAuthProviderTokenServices);
            //setIgnoreMissingCredentials(false); // die if OAuth params are not included
        }
    }
}