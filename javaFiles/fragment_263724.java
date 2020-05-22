Socket sock = new Socket();  
try {
    sock.connect(new InetSocketAddress("www.google.com.ph", 80));
    InputStream in = sock.getInputStream();
    OutputStream out = sock.getOutputStream();

    out.write(new String("GET / HTTP/1.1\r\nHost: www.google.com.ph\r\n\r\n").getBytes());

    byte[] readBuffer = new byte[4096];
    while(true) {
        int readSize = in.read(readBuffer);
        if(readSize < 1) break;
        System.out.println(new String(readBuffer, 0, readSize));
    }

    sock.close();
} catch(Exception e) {
    e.printStackTrace();
}