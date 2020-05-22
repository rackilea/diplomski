@Bean
    @SneakyThrows
    public RequestHeaderAuthenticationFilter preAuthenticationFilter() {
        RequestHeaderAuthenticationFilter preAuthenticationFilter = new RequestHeaderAuthenticationFilter();
        preAuthenticationFilter.setPrincipalRequestHeader(SESSION_ID);
        preAuthenticationFilter.setCredentialsRequestHeader(SESSION_ID);
        preAuthenticationFilter.setExceptionIfHeaderMissing(false);
        preAuthenticationFilter.setContinueFilterChainOnUnsuccessfulAuthentication(true);
        preAuthenticationFilter.setAuthenticationManager(authenticationManager());

        return preAuthenticationFilter;
    }