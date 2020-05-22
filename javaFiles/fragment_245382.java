public class SessionMonitor implements HttpSessionListener {
    protected final Log logger = LogFactory.getLog(getClass());

    protected CopyOnWriteArrayList<SessionEventListener> subscribers = new CopyOnWriteArrayList<SessionEventListener>();
    protected ConcurrentHashMap<String,HttpSession> sessions = new ConcurrentHashMap<String,HttpSession>();
    protected static SessionMonitor singleton;
    public static SessionMonitor soleInstance() throws ConfigurationException {
        if (singleton == null)
            throw new ConfigurationException("No SessionMonitor instance has been created");
        return singleton;
    }

    public SessionMonitor() {
        if (singleton == null)
            singleton = this;
    }

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        this.sessions.putIfAbsent(session.getId(), session);
        logger.trace("Registered session " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        String sessionId = e.getSession().getId();
        this.sessions.remove(sessionId);
        for (SessionEventListener listener: subscribers)
            listener.sessionEnded(sessionId);
        logger.trace("Removed session " + sessionId);
    }

    public HttpSession getSession(String id) {
        return this.sessions.get(id);
    }

    public void addListener(SessionEventListener listener) {
        this.subscribers.add(listener);
        logger.trace("Added listener " + listener);
    }

    public void removeListener(SessionEventListener listener) {
        this.subscribers.remove(listener);
        logger.trace("Removed listener " + listener);
    }
}