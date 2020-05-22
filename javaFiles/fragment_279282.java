public class SocketWrapper implements Closeable {
    private final Socket socket;

    public SocketWrapper(Socket socket) {
        this.socket = socket;
    }

    /**
    * Provide all the methods you need in your application
    * for accessing the internal socket
    */

    public void close() throws IOException {
        socket.close();
        fireClosedEvent();
    }

    /**
    * Event firing methods, etc.
    */
}