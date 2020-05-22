public void server() throws IOException {
    ServerSocket serverSocket = new ServerSocket(8080);
    Socket socket = serverSocket.accept();
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintStream ps = new PrintStream(socket.getOutputStream()); 

    // Just read a line and echo it till EOF
    String line;
    while((line = reader.readLine()) != null) ps.println(line);
}