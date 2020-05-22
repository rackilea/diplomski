/**
 * Parse session id in URL.
 */
protected void parseSessionCookiesId(org.apache.coyote.Request req, Request request) {

    // If session tracking via cookies has been disabled for the current
    // context, don't go looking for a session ID in a cookie as a cookie
    // from a parent context with a session ID may be present which would
    // overwrite the valid session ID encoded in the URL
    Context context = (Context) request.getMappingData().context;
    if (context != null && !context.getServletContext()
            .getEffectiveSessionTrackingModes().contains(
                    SessionTrackingMode.COOKIE)) {
        return;
    }

    // Parse session id from cookies
    Cookies serverCookies = req.getCookies();
    int count = serverCookies.getCookieCount();
    if (count <= 0) {
        return;
    }

    String sessionCookieName = SessionConfig.getSessionCookieName(context);

    for (int i = 0; i < count; i++) {
        ServerCookie scookie = serverCookies.getCookie(i);
        if (scookie.getName().equals(sessionCookieName)) {
            // Override anything requested in the URL
            if (!request.isRequestedSessionIdFromCookie()) {
                // Accept only the first session id cookie
                convertMB(scookie.getValue());
                request.setRequestedSessionId
                    (scookie.getValue().toString());
                request.setRequestedSessionCookie(true);
                request.setRequestedSessionURL(false);
                if (log.isDebugEnabled()) {
                    log.debug(" Requested cookie session id is " +
                        request.getRequestedSessionId());
                }
            } else {
                if (!request.isRequestedSessionIdValid()) {
                    // Replace the session id until one is valid
                    convertMB(scookie.getValue());
                    request.setRequestedSessionId
                        (scookie.getValue().toString());
                }
            }
        }
    }

}