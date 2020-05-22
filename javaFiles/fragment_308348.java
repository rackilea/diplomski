DatagramChannel datagramChannel = DatagramChannel.open();
    DatagramSocket datagramSocket = datagramChannel.socket();
    datagramSocket.setReuseAddress(true);
    datagramSocket.bind(new InetSocketAddress(HOST, PORT));
    datagramSocket.connect(address);
    datagramChannel.configureBlocking(false);

    datagramChannel.register(selector, SelectionKey.OP_READ);