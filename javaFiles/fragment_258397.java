public static void main(String[] args) {
    try {
        DatagramSocket s = new DatagramSocket(null);
        InetSocketAddress address = new InetSocketAddress("192.168.103.255", 3000);
        s.bind(address);

    } catch (Exception e) {
        e.printStackTrace();
    }
}