byte[] buffer = new byte[1000];
DatagramPacket p = new DatagramPacket(buffer, buffer.length);
DatagramSocket receiveSocket = new DatagramSocket(5505, InetAddress.getByName("127.0.0.1"));
receiveSocket.setSoTimeout(5000);
while (true) {
    try {
        receiveSocket.receive(p);
    } catch (SocketTimeoutException ste) {
        System.out.println("### Timed out after 5 seconds");
    }
}