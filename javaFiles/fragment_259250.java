public class SessionInvalidationFilter implements Filter {

    private static final String LAST_ACCESS_SESSION_ATTR = "lastAccessTime";

    private static final long SESSION_TIMEOUT = 1000 * 60 * 20; // 20 minutes

    private static final String IGNORE_ACCESS_URI = "/this/will-not/update/access-time";

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Cast to HTTP request and response
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // Check if we are handling standard request
        if (!IGNORE_ACCESS_URI.equals(httpRequest.getRequestURI())) {
            chain.doFilter(new SessionAccessAwareRequest(httpRequest), response);
            return;
        }
        // Now we can handle the special case of non-tracked request
        boolean expired = false;
        HttpSession session = httpRequest.getSession(false);
        if (session == null) {
            // No session means the AJAX contained no or incorrect JSESSIONID
            expired = true;
        } else {
            Long lastAccessTime = (Long) session.getAttribute(LAST_ACCESS_SESSION_ATTR);
            if (lastAccessTime == null || lastAccessTime + SESSION_TIMEOUT < System.currentTimeMillis()) {
                session.invalidate(); // Invalidate manually
                expired = true;
            }
        }
        // Handle error or process normally
        if (expired) {
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            chain.doFilter(request, response);
        }
    }

    private static class SessionAccessAwareRequest extends HttpServletRequestWrapper {

        public SessionAccessAwareRequest(HttpServletRequest request) {
            super(request);
        }

        @Override
        public HttpSession getSession() {
            return getSession(true);
        }

        @Override
        public HttpSession getSession(boolean create) {
            HttpSession session = super.getSession(create);
            if (session != null) {
                session.setAttribute(LAST_ACCESS_SESSION_ATTR, System.currentTimeMillis());
            }
            return session;
        }

    }

}