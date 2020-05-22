ServerSocket srvSock = new ServerSocket(1234);
Socket sock = srvSock.accept();
returnAddress = sock.getInetAddress();
returnPort = sock.getPort();
DataInputStream iStream = new DataInputStream(sock.getInputStream());
byte[] buf = new byte[100000];
iStream.readFully(buf);