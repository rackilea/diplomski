ServerSocket welcomeSocket = new ServerSocket(6786);
while(true){
    Socket connectionSocket = welcomeSocket.accept();
    ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
    ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
    int[] arrFromClient = (int[]) inFromClient.readObject();
    Arrays.sort(arrFromClient);
    outToClient.writeObject(arrFromClient);
}