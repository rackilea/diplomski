public class MySessionAuthenticationStrategy extends ConcurrentSessionControlStrategy {
    int MAX_USERS = 1000; // Whatever
    SessionRegistry sr;

    public MySessionAuthenticationStrategy(SessionRegistry sr) {
        super(sr);
        this.sr = sr;
    }

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        if (sr.getAllPrincipals().size() > MAX_USERS) {
            throw new SessionAuthenticationException("Maximum number of users exceeded");
        }
        super.onAuthentication(authentication, request, response);
    }
}