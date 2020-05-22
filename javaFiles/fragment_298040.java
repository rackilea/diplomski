int MYPORT = 5555;
  DatagramSocket dsocket = new DatagramSocket(MYPORT);
  byte[] buffer = new byte[2048];

  // Create a packet to receive data into the buffer
  DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

  while (true) {
    // Wait to receive a datagram
    dsocket.receive(packet);

    // Convert the contents to a string, and display them
    String msg = new String(buffer, 0, packet.getLength());
    System.out.println(packet.getAddress().getHostName() + ": "
        + msg);

    // Reset the length of the packet before reusing it.
    packet.setLength(buffer.length);

    System.out.printf(" using port %d\n", packet.getPort());
  }