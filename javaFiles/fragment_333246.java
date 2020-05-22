DatagramSocket socket = new DatagramSocket(PORT);
socket.setBroadcast(true);
DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(),
    getBroadcastAddress(), PORT);
socket.send(packet);

// If you want to listen for a response ...
byte[] buf = new byte[1024];
DatagramPacket packet = new DatagramPacket(buf, buf.length);
socket.receive(packet);