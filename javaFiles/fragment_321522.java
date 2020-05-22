@Component
public class AuthenticationFailedHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // super.onAuthenticationFailure(request, response, exception);    
        // failed
    }
}