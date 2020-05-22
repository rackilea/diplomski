@Bean
public WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
    ServerOAuth2AuthorizedClientExchangeFilterFunction oauthFilter =
      new ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrations,
        new UnAuthenticatedServerOAuth2AuthorizedClientRepository());
    oauth.setDefaultClientRegistrationId("custom");
    return WebClient.builder()
      .filter(oauthFilter)
      .build();
}