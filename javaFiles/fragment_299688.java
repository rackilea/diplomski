public class SessionCounter implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    private static final String ATTRIBUTE_NAME = "com.example.SessionCounter";
    private Map<HttpSession, String> sessions = new ConcurrentHashMap<HttpSession, String>();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        HttpSession session = request.getSession();
        if (session.isNew()) {
            sessions.put(session, request.getRemoteAddr());
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        sessions.remove(event.getSession());
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // NOOP. Useless since we can't obtain IP here.
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        // NOOP. No logic needed.
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP. No logic needed. Maybe some future cleanup?
    }

    public static SessionCounter getInstance(ServletContext context) {
        return (SessionCounter) context.getAttribute(ATTRIBUTE_NAME);
    }

    public int getCount(String remoteAddr) {
        return Collections.frequency(sessions.values(), remoteAddr);
    }

}