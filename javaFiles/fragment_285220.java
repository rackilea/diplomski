@Bean
public OAuth2AuthorizedClientManager authorizedClientManager(
        ClientRegistrationRepository clientRegistrationRepository,
        OAuth2AuthorizedClientService clientService)
{

    OAuth2AuthorizedClientProvider authorizedClientProvider = 
        OAuth2AuthorizedClientProviderBuilder.builder()
            .clientCredentials()
            .build();

    AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = 
        new AuthorizedClientServiceOAuth2AuthorizedClientManager(
            clientRegistrationRepository, clientService);
    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

    return authorizedClientManager;
}

@Bean
WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager)
{
    ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 =
        new ServletOAuth2AuthorizedClientExchangeFilterFunction(
            authorizedClientManager);
    oauth2.setDefaultClientRegistrationId("keycloak");
    return WebClient.builder().apply(oauth2.oauth2Configuration()).build();
}