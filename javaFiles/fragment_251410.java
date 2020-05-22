@Configuration
    @EnableAuthorizationServer
    public class AuthorizationApplication extends AuthorizationServerConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                throws Exception {
            endpoints
                    .userDetailsService(userDetailsService)
                    .authenticationManager(this.authenticationManager).tokenStore(tokenStore()).approvalStoreDisabled();
        }

       @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.withClientDetails(mongoClientDetailsService);
            /*inMemory()
                    .withClient(propertyResolver.getProperty(PROP_CLIENTID))
                    .scopes("read", "write")
                    .authorities("ROLE_CLIENT")
                    .authorizedGrantTypes("password", "refresh_token","client_credentials")
                    .secret(propertyResolver.getProperty(PROP_SECRET))
                    .accessTokenValiditySeconds(propertyResolver.getProperty(PROP_TOKEN_VALIDITY_SECONDS, Integer.class, 18000));*/
        }

//Do others stuff
    }