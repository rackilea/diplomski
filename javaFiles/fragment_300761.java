public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Set status only OR do whatever you want to the response
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}