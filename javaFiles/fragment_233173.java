public void readData(Connection c) throws IOException {
    while (c.getIn().available() > 0) {
        int packetSize = c.getIn().read();
        c.getIn().mark(packetSize);
        byte[] buffer = new byte[packetSize];
        c.getIn().read(buffer, 0, buffer.length);
        PacketBuffer readBuffer = new PacketBuffer(Server.PACKET_CAPACITY);
        readBuffer.setBuffer(buffer);
        packetHandler.addProcess(c, readBuffer);
    }