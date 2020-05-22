HttpClientContext clientContext = HttpClientContext.create();
PlainConnectionSocketFactory sf = PlainConnectionSocketFactory.getSocketFactory();
Socket socket = sf.createSocket(clientContext);

int timeout = 1000; // ms <-- 

HttpHost target = new HttpHost("localhost");
InetSocketAddress remoteAddress = new InetSocketAddress(InetAddress.getByAddress(new byte[] {127,0,0,1}), 80);
sf.connectSocket(timeout, socket, target, remoteAddress, null, clientContext);