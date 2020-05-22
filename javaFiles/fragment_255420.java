@Bean
    public AuthenticationSuccessHandler mySuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/courses");
        return handler;
    }