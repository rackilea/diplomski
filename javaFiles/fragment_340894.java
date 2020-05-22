DatagramSocket mServerSocket = new DatagramSocket(PORT);
InetAddress  broadcastAddress=InetAddress.getByName("255.255.255.255");
byte[] data=new byte[1024];
data="your_data_string_example".getBytes();
DatagramPacket packet=new DatagramPacket(sendData,
                            sendData.length,broadcastAddress,PORT);
mServerSocket.setBroadcast(true);
mServerSocket.send(packet);