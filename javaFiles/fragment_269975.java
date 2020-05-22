byte[] receiveData = new byte[1328];
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
try {
    udpSocket.receive(receivePacket);
} catch (IOException e) {
    e.printStackTrace();
}