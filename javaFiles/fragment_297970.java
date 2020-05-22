DatagramSocket s = new DatagramSocket(null);
s.bind(new InetSocketAddress("127.0.0.1", port));
s.close();

s = new DatagramSocket(null);
s.bind(new InetSocketAddress("localhost", port));
s.close();