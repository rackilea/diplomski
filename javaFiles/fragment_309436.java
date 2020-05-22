private void test(OutputStream sockOutput, String[] ip) throws IOException {
    String receive = sendUDPBytes("request", ip);

    if (receive.length() <= 0) // Waiting forever, and nothing happens LINUX.
    {
        System.out.println("FAILED");
        System.exit(0);
    } else {
        try {
            /*
             * JOB todo
             */
        } catch (Exception ex) {
        }
    }
    sockOutput.write(receive.getBytes("UTF-8"));
}

public static String sendUDPBytes(String bytes, String[] ip) throws IOException {
    return new String(sendUDPBytesRaw(bytes.getBytes("UTF-8"), ip), "UTF-8");
}

public static byte[] sendUDPBytesRaw(byte[] sendData, String[] ip) throws IOException {
    DatagramSocket socket = new DatagramSocket();
    InetAddress IPAddress = InetAddress.getByName(ip[2]);

    byte[] receiveData = new byte[14024];

    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length);
    socket.connect(IPAddress, 58889);
    if (socket.isConnected()) {
        System.out.println("[UDP]: sending....., waiting......... until receive....");
        socket.send(sendPacket);
    }

    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    socket.receive(receivePacket);
    byte[] downloaded = receivePacket.getData();

    System.out.println("[UDP]: closing.....");
    socket.close();
    return downloaded;
}