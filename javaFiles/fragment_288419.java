public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = null;
    try {
        serverSocket = new ServerSocket(4444);
    } catch (IOException e) {
        System.err.println("Could not listen on port: 4444.");
        System.exit(1);
    }

    Socket clientSocket = null;
    try {
        clientSocket = serverSocket.accept();
    } catch (IOException e) {
        System.err.println("Accept failed.");
        System.exit(1);
    }

    // Set a 1 second timeout on the socket
    clientSocket.setSoTimeout(1000);

    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
            new InputStreamReader(
            clientSocket.getInputStream()));

    long myNextOutputTime = System.currentTimeMillis() + 30000;

    String inputLine = null;
    boolean connected = true;
    while (connected)
    {
        try {
            inputLine = in.readLine();
            if (inputLine == null)
            {
                System.out.println("Client Disconnected!");
                connected = false;
            }
        }
        catch(java.net.SocketTimeoutException e)
        {
            System.out.println("Timed out trying to read from socket");
        }

        if (connected && (System.currentTimeMillis() - myNextOutputTime > 0))
        {
            out.println("My Message to the client");
            myNextOutputTime += 30000;
        }


    }

    out.close();
    in.close();
    clientSocket.close();
    serverSocket.close();
}