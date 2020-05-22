public void Client() throws IOException {
    // Client that closes the communication when the user types "quit"
    Socket socket = new Socket("localhost", 8080);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintStream ps = new PrintStream(socket.getOutputStream()); 

    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while(!(line = user.readLine()).equals("quit")) {
        ps.println(line); // Write to server
        System.out.println(reader.readLine()); // Receive echo
    }
    socket.shutdownOutput(); // Send EOF to server
    socket.close();
}