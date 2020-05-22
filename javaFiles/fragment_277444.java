private final static int PORT_NUMBER = 3333;
    try (
        //ServerSocket listening to port 3333
        ServerSocket serverSocket =
            new ServerSocket(PORT_NUMBER);
        //ServerSocket.accept(); blocks program execution until a client socket connects,
        //put it in a loop to listen for continuous connections
        Socket clientSocket = serverSocket.accept();    
        PrintWriter out =
            new PrintWriter(clientSocket.getOutputStream(), true);                  
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
    ) {
        //Read data from streams
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            out.println(inputLine);
        }
    } catch (IOException e) {
        System.out.println("Exception caught when trying to listen on port "
            + portNumber + " or listening for a connection");
        System.out.println(e.getMessage());
    }