private Map<Integer, Session> sessions        = new HashMap<IntegerPatternConverter, Session>();

    ...
    // Client listen loop
    while (true) {
        int key = ++lastId;
        newSession = initSession (key);
        synchronized (this) {
            sessions.put (key, newSession);
        }
        new Thread (newSession).start ();
    }
...
public void cleanupSession (int closedSessionKey) {
    synchronized (this) {
        sessions.remove (closedSessionKey);
    }
}