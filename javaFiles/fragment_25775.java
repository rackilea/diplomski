private class AllUsersConcurrentSessionControlAuthenticationStrategy extends ConcurrentSessionControlAuthenticationStrategy {

    // probably inject this from application configuration
    private final int maxUsers;
    private final SessionRegistry sessionRegistry;

    public AllUsersConcurrentSessionControlAuthenticationStrategy(int maxUsers, SessionRegistry sessionRegistry) {
        super(sessionRegistry);
        this.maxUsers = maxUsers;
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request,
                                 HttpServletResponse response) {
        if (sessionRegistry.getAllPrincipals().size() > maxUsers) {
            throw new SessionAuthenticationException("...");
        }
        super.onAuthentication(authentication, request, response);
    }
}