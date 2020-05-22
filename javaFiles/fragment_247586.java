public static void main (String[] args) throws IOException {
    try (DatagramSocket socket = new DatagramSocket(PORT_NUMBER)) {
      boolean loop = true;
      final byte[] buffer = new byte[BUFFER_SIZE];
      final DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      while (loop) {
        socket.receive(packet);
        final String text = new String(packet.getData()).trim();
        switch (text) {
          case "exit":
            loop = false;
            break;
          case "scan":
            scan();
            break;
          default:
            System.err.printf("Received unknown command `%s`%n", text);
        }
      }
    }
  }