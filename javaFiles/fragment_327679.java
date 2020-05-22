receiveSocket.receive(packetToReceive);
receiveBuffer = new byte[packetToReceive.getLength()];
System.arraycopy(packetToReceive.getData(), packetToReceive.getOffset(), receiveBuffer, 0, packetToReceive.getLength());

String receivedMessage = new String(receiveBuffer);

if(!receivedMessage.equals("exit")) {   
    System.out.println("A says: " + receivedMessage);
}
else {
    input = "exit";
}