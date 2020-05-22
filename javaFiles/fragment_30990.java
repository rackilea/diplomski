public ClientHandler(Socket client, int id) {
   this.id = id; // ADD THIS LINE
    try {

        //Get BufferedReader from client
        this.client = client;
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    } catch (IOException e) {
        e.printStackTrace();
    }
}