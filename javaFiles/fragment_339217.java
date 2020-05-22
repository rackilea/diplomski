public void initialize(int port){

    try {
        ServerSocket sc = new ServerSocket(port);
        //Show Server GUI
        drawGUI();
        //Listen to server port and accept clients connections
        while(true){
            Socket client = sc.accept();
            System.out.println("New client Connected to the server");
            //Per each client create a ClientHandler
            new ClientHandler(client,desktop);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}