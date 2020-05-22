public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception) {
        if (exception instanceof DisabledException) {
            // throw new exception or modify response
        }
    }
}