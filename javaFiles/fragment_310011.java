class AuthenticatingMyHandlerClass extends MyHandlerClass {

    @GetMapping("/thing")
    public ResponseEntity getThing(@CookieValue("Session-Token") String sessionToken) {
        User user = authenticator.authenticateSessionTokenOrThrow(sessionToken);
        ResponseEntity ret = super.getThing(sessionToken);
        doSomethingWith(ret);
        return ret;
    }