ServerSocketFactory sf = SSLServerSocketFactory.getDefault();
final SSLServerSocket socket = (SSLServerSocket)sf.createServerSocket(443);
System.out.println(Arrays.toString(socket.getSupportedCipherSuites()));
System.out.println(Arrays.toString(socket.getEnabledCipherSuites()));

socket.setEnabledCipherSuites(new String[] {"SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA"});

Thread t = new Thread() {
    public void run() {
        try {
            Socket client = socket.accept();
            client.getOutputStream().write("Hello World\n".getBytes("ASCII"));
            client.close();
        } catch (IOException ioe) {
        }
    }
};

t.start();
Thread.sleep(2000);
SSLSocket client = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 443);
client.setEnabledCipherSuites(new String[] {"SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA"});
InputStream in = client.getInputStream();
byte[] data = new byte[1024];
int len = in.read(data);
System.out.println(new String(data, 0, len));