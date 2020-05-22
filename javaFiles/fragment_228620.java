TorProxyAddress = new InetSocketAddress("127.0.0.1", 9050);
Proxy TorProxy = new Proxy(Proxy.Type.SOCKS, TorProxyAddress);
Socket underlying = new Socket(TorProxy);

InetSocketAddress unresolvedAdr = InetSocketAddress.createUnresolved(host, port);
underlying.connect(unresolvedAdr);

SSLSocket socket = (SSLSocket) SockFactory.createSocket(underlying, "127.0.0.1", 9050, true);
// ... Read from / write to Socket