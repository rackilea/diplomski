public class ConnectionProxy implements Connectable {

    // where Connectable is some shared interface between ConnectionProxy
    // and SSHConnection. The proxy should "look like" a connection, it just
    // hides the actual connection behind the scenes.

    private static SSHConnection connection;

    public ConnectionProxy() { }

    public ConnectionProxy(String host, int port) {
        connection = new SSHConnection(host, port);
    }

    public void connect(String host, int port) {
        if (isConnected()) {
            return;
        }
        connection = new SSHConnection(host, port);
    }

    public void reconnect() {
        connection = new SSHConnection(connection.getHost(), connection.getPort());
    }

    public boolean isConnected() {
        return connection != null && connection.isConnected();
    }
}