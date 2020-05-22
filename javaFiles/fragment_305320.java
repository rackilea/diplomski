...
Tcp(InetAddress server, int port, int timeout) throws IOException {
    sock = new Socket(server, port);
    sock.setSoTimeout(timeout);  // <-- missing timeout
    sock.setTcpNoDelay(true);
    out = new java.io.BufferedOutputStream(sock.getOutputStream());
    in = new java.io.BufferedInputStream(sock.getInputStream());
}
...