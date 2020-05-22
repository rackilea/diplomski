public class SSDPSocket {
    SocketAddress mSSDPMulticastGroup;
    MulticastSocket mSSDPSocket;
    InetAddress broadcastAddress;

    public SSDPSocket() throws IOException {

        mSSDPSocket = new MulticastSocket();
        broadcastAddress  = InetAddress.getByName(SSDPConstants.ADDRESS);
        mSSDPSocket.joinGroup(broadcastAddress);
    }
...
}