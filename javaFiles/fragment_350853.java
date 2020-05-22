public class Sam implements ServerAuthModule {

    // ...

    @Override
    public AuthStatus validateRequest(MessageInfo mi, Subject client, Subject service) throws AuthException {
        boolean authenticated = false;
        boolean attachAuthnInfoToSession = false;
        final String callerSessionKey = "authn.caller";
        final String groupsSessionKey = "authn.groups";
        final HttpServletRequest req = (HttpServletRequest) mi.getRequestMessage();
        TokenPrincipal tp = null;
        String[] groups = null;
        String token = null;
        HttpSession hs = req.getSession(false);
        if (hs != null) {
            tp = (TokenPrincipal) hs.getAttribute(callerSessionKey);
            groups = (String[]) hs.getAttribute(groupsSessionKey);
        }
        Callback[] callbacks = null;
        if (tp != null) {
            callbacks = new Callback[] { new CallerPrincipalCallback(client, tp), new GroupPrincipalCallback(client, groups) };
            authenticated = true;
        }
        else if (isValid(token = req.getParameter("token"))) {
            tp = newTokenPrincipal(token);
            groups = fetchGroups(tp);
            callbacks = new Callback[] { new CallerPrincipalCallback(client, tp), new GroupPrincipalCallback(client, groups) };
            authenticated = true;
            attachAuthnInfoToSession = true;
        }
        if (authenticated) {
            try {
                handler.handle(callbacks);
                if (attachAuthnInfoToSession && ((hs = req.getSession(false)) != null)) {
                    hs.setAttribute(callerSessionKey, tp);
                    hs.setAttribute(groupsSessionKey, groups);
                }
            }
            catch (IOException | UnsupportedCallbackException e) {
                throw (AuthException) new AuthException().initCause(e);
            }
            return AuthStatus.SUCCESS;
        }
        return AuthStatus.SEND_FAILURE;
    }

    // ...

    @Override
    public void cleanSubject(MessageInfo mi, Subject subject) throws AuthException {
        // ...
        // just to be safe
        HttpSession hs = ((HttpServletRequest) mi.getRequestMessage()).getSession(false);
        if (hs != null) {
            hs.invalidate();
        }
    }

    private boolean isValid(String token) {
        // whatever
        return ((token != null) && (token.length() == 10));
    }

    private TokenPrincipal newTokenPrincipal(String token) {
        // whatever
        return new TokenPrincipal(token);
    }

    private String[] fetchGroups(TokenPrincipal tp) {
        // whatever
        return new String[] { "aRole" };
    }

}