public class SessionData implements HttpSessionListener {
    private final static Map<String, HttpSession> activeSessions = new ConcurrentHashMap<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        if (session != null) {
            String id = session.getId();
            System.out.println("HTTP session created. ID: " + id);
            activeSessions.put(id, session);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        if (session != null) {
            String id = session.getId();
            System.out.println("HTTP session destroyed. ID: " + id);
            activeSessions.remove(id);
        }
    }
}