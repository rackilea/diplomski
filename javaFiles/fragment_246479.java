private static Socket s = new Socket();

static {
    try {
        s.bind(new InetSocketAddress(9000));
    } catch (IOException e) {
        e.printStackTrace();
    }
}