DatagramSocket s = new DatagramSocket(null);
s.bind(new InetSocketAddress("127.0.0.1", port));

s = new DatagramSocket(null);
s.setReuseAddress(true);
s.bind(new InetSocketAddress("localhost", port));