socket = new MulticastSocket();
socket.setReuseAddress(true);//redundant, already set with empty constructor
SocketAddress sockAddr = new InetSocketAddress(PORT);
socket.bind(sockAddr);
InetAddress group = InetAddress.getByName(ADDRESS);
socket.joinGroup(group);
socket.setTimeToLive(TTL);