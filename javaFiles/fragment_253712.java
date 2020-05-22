ServerSocket serverSocket = new ServerSocket(8080);
while (true) {
    Socket clientSocket = serverSocket.accept();
    PrintWriter out =
            new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
    String line = in.readLine();
    System.out.println("SERVER: received " + line);
    out.println("server error");
    out.close();
    in.close();
    clientSocket.close();
}