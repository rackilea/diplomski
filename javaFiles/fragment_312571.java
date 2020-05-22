@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

        .....   // other config

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenServices(this.customTokenServices());
    }

    private DefaultTokenServices customTokenServices() {
        DefaultTokenServices tokenServices = new CustomTokenServices();
        tokenServices.setTokenStore(new InMemoryTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(true);
        tokenServices.setClientDetailsService(this.clientDetailsService);
        return tokenServices;
    }

    private static class CustomTokenServices extends DefaultTokenServices {
        private TokenStore tokenStore;

        @Override
        public OAuth2AccessToken refreshAccessToken(String refreshTokenValue, TokenRequest tokenRequest) throws AuthenticationException {
            OAuth2RefreshToken refreshToken = this.tokenStore.readRefreshToken(refreshTokenValue);
            OAuth2Authentication authentication = this.tokenStore.readAuthenticationForRefreshToken(refreshToken);

            // Check attributes in the authentication and
            // decide whether to grant the refresh token
            boolean allowRefresh = true;

            if (!allowRefresh) {
                // throw UnauthorizedClientException or something similar

            }

            return super.refreshAccessToken(refreshTokenValue, tokenRequest);
        }

        @Override
        public void setTokenStore(TokenStore tokenStore) {
            super.setTokenStore(tokenStore);
            this.tokenStore = tokenStore;
        }
    }
}