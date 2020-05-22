import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
...
String host = "www.google.com";
int port = 443;
SocketFactory basicSocketFactory = SocketFactory.getDefault();
Socket s = basicSocketFactory.createSocket(host,port);
// s is a TCP socket
SSLSocketFactory tlsSocketFactory = SSLSocketFactory.getDefault();
s = tlsSocketFactory.createSocket(s, host, port, true);
// s is now a TLS socket over TCP