try {
    // Get input from the client
    DataInputStream in = new DataInputStream (server.getInputStream());
    PrintStream out = new PrintStream(server.getOutputStream());
    out.println("You have connected to the server.");
    out.println("Welcome.");
    in.readLine(); //consume first two bytes
    //the rest of your code...