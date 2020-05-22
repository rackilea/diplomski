public class Subscription implements Serializable {

    private String type;

    // instead of InetSocketAddress
    private String host;
    private int port;

    public InetSocketAddress getSocketAddress() {
            return new InetSocketAddress(host, port);
    }

    // setters and getters