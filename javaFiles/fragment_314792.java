private Thread serverThread;
IOException thrown;

public void runServer() throws IOException {
    if (serverThread != null) {
        throw new IOException("Server is already running");
    }
    serverThread = new Thread(new Runnable() {
        public void run() {
            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(PORT);
                DatagramPacket packet = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
                while (server_status) {
                    packet.setLength(BUFFER_SIZE);
                    socket.receive(packet);
                    System.out.write(packet.getData());
                    redirectToFile(packet.getData());
                }
            } catch (IOException e) {
                thrown = e;
            } finally {
                serverThread = null;
                if (socket != null) socket.close();
            }
        }
    });
    serverThread.start();
}