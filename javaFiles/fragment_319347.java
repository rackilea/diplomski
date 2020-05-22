public class ConnectionHandlerPool {
    private static final List<ConnectionThread> pool = new ArrayList<ConnectionThread>();
    // When new threads are created, they get a reference to the pool they're in
    private void addConnection() {
        pool.add(new ConnectionThread(pool));
    }
    private void disconnect(ConnectionThread ct) {
        pool.remove(ct);
    }
}

public class ConnectionHandlerThread {
    private final ConnectionHandlerPool pool;
    public ConnectionHandlerThread(ConnectionHandlerPool pool) {
        this.pool = pool;
    }

    private void destroy() {
        pool.disconnect(this);
    }
}