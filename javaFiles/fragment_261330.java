...
public void run () throws IOException {

    Session newSession;

    // Client listen loop
    while (true) {
        ...
        newSession = initSession (++lastId);
        synchronized (this) {
            sessions.add (newSession);
        }
        ...
    }
}

public void cleanupSession (Session closedSession) {
    synchronized (this) {
        sessions.remove (closedSession);
    }
}