int arrFromClient[]=new int[10];
ServerSocket welcomeSocket = new ServerSocket(6786);
while(true){
    Socket connectionSocket = welcomeSocket.accept();
    DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    for(int i=0;i<10;i++) {
        arrFromClient[i] = inFromClient.readInt();
    }
    Arrays.sort(arrFromClient);
    for (int i = 0; i < arrFromClient.length; i++) {
        outToClient.writeInt(arrFromClient[i]);
    }
}