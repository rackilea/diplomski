Principal principal = request.getUserPrincipal();
if (principal == null) {
    Session session = request.getSessionInternal(false);
    if (session != null) {
        principal = session.getPrincipal();
        if (principal != null) {
            if (log.isDebugEnabled())
                log.debug("We have cached auth type " +
                    session.getAuthType() +
                    " for principal " +
                    session.getPrincipal());
            request.setAuthType(session.getAuthType());
            request.setUserPrincipal(principal);
        }
    }
}