@Bean
public RequestInterceptor requestTokenBearerInterceptor() {

    return new RequestInterceptor() {
        @Override
        public void apply(RequestTemplate requestTemplate) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            requestTemplate.header("Authorization", "Bearer " + details.getTokenValue());                   
        }
    };
}