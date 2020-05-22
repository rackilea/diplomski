public CommunicationThread(String hostname, int port, int timeout) throws IOException, SocketTimeoutException {
    InetSocketAddress address = new InetSocketAddress(hostname, port);   
    socket = new Socket();
    socket.connect(address, 2000); // 2000ms time out
    // You can use the writer to write messages back out to the server
    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));         
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
}