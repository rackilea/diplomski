while (true) {
    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    serverSocket.receive(receivePacket);
    // get the entire content
    byte telegramContent[] = receivePacket.getData();
    // and slice it up:

    byte ID[] = Arrays.copyOfRange(telegramContent,0,5); 
    byte payload[] = Arrays.copyOfRange(telegramContent,6,11);
    // and so on.
}