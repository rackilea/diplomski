WifiManager wifi = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
MulticastLock lock = wifi.createMulticastLock("dk.aboaya.pingpong");
lock.acquire();
serverSocket = new DatagramSocket(19876);
serverSocket.setSoTimeout(15000); //15 sec wait for the client to connect
byte[] data = new byte[UDPBatPositionUpdater.secretWord.length()]; 
DatagramPacket packet = new DatagramPacket(data, data.length);
serverSocket.receive(packet);
lock.release();
String s = new String(packet.getData());
System.out.println(s);