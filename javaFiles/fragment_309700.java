receivedData = new byte[1024];
receivedPacket = new DatagramPacket(receivedData, receivedData.length);
socket.receive(receivedPacket);
receivedData = receivedPacket.getData();
String charsetName = "US-ASCII"; // set to desired charset
String res = new String(receivedData, 0, receivedPacket.getLength(), charsetName);