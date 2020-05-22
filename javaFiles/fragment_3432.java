public interface NetworkService {
    public Socket createSocket();
}

class NetworkServiceImpl implements NetworkService {
    static final Proxy DEFAULT_PROXY = new Proxy(...);

    public Socket createSocket() {
        Socket s = new Socket(DEFAULT_PROXY);
        s.setReceiveBufferSize(4096);
        return s;
    } 
}