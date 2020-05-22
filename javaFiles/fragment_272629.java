protected RestKeyCloakClient()
{
    MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
    OAuth2RestTemplate client;
    DefaultAccessTokenRequest accessTokenRequest = new DefaultAccessTokenRequest();
    DefaultOAuth2ClientContext context = new DefaultOAuth2ClientContext(accessTokenRequest);
    OAuth2AccessTokenSupport support = new OAuth2AccessTokenSupport()
    {
    };
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    messageConverters.add(new FormOAuth2AccessTokenMessageConverter());
    messageConverters.add(new FormOAuth2ExceptionHttpMessageConverter());
    MappingJackson2HttpMessageConverter jackson = new MappingJackson2HttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    mediaTypes.add(new MediaType("application", "x-www-form-urlencoded"));
    jackson.setSupportedMediaTypes(mediaTypes);
    messageConverters.add(jackson);
    support.setMessageConverters(messageConverters);
    client = new OAuth2RestTemplate(getAuthDetails(null, null), context);
    client.setErrorHandler(errorHandler);
    client.setRequestFactory(factory);
    token = client.getAccessToken();
}