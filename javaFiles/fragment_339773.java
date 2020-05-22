public class MyTcpNetClientConnectionFactory extends TcpNetClientConnectionFactory {

    protected Socket createSocket(String host, int port) throws IOException {
        Socket socket = getTcpSocketFactorySupport().getSocketFactory().createSocket();
        socket.connect(new InetSocketAddress(host, port), 1000);
        return socket;
    }
}