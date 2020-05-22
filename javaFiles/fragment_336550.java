@Bean
public AuthenticationSuccessHandler successHandler() {
    SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
    handler.setTargetUrlParameter("redirectTo");
    handler.setDefaultTargetUrl("/");
    return handler;
}