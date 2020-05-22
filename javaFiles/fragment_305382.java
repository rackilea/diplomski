class ConnectionPool {

    private final StreamConnectionPool streamPool = ...;

    Connection getConnection() {
        final StreamConnection realConnection = streamPool.borrowConnection();
        return new Connection(){
            private boolean closed = false;
            int read () {
                if (closed) throw new IllegalStateException("Connection closed"); 
                return realConnection.read();
            }
            void close() {
                if (!closed) {
                    closed = true;
                    streamPool.returnConnection(realConnection);
                }
            }
            protected void finalize() throws Throwable {
                try {
                    close();
                } finally {
                    super.finalize();
                }
            }
        };
    }

}