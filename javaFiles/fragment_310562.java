private void receivePacket(DatagramSocket serverSocket, byte[] receiveData)
        throws IOException {
    // create a new array
    byte[] rData = new byte[1024];
    // throw away the orignal array so the new array will be update.
    receiveData = rData;
    // copy into the new array, not the old one.
    receivePacket = new DatagramPacket(receiveData, receiveData.length);
    serverSocket.receive(receivePacket);
}