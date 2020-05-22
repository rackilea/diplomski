send(msg, bytesRead);
...
private void send(byte[] message, int length) throws IOException {
    DatagramPacket packet = new DatagramPacket(message, length);
    socket.send(packet);
}