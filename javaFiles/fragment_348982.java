public class ConnectionCloser implements Closeable {

    private Connection connection;

    public ConnectionCloser(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() throws IOException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IOException("Exception encountered while closing connection", e);
        }
    }

}