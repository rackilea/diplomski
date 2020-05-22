Optional<Principal> principal = request.getUserPrincipal();
if (!principal.isPresent()) {
    Optional<Session> session = request.getSessionInternal(false);
    principal = session.flatMap((sess) { sess.getPrincipal() });
    principal.flatMap((principal) {
        if (log.isDebugEnabled()) ... // as before
        request.setAuthType(session.getAuthType());
        request.setUserPrincipal(principal);
    })
}