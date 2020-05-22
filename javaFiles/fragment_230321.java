String clientSentence;          
String capitalizedSentence;          

//server listes at port number
ServerSocket welcomeSocket = new ServerSocket(6789);          

//server is running forever...
while(true) {
    //... and is accepting connections
    Socket connectionSocket = welcomeSocket.accept();

    //receives string messages ...
    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));             

    //... and sends messages
    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());             
    clientSentence = inFromClient.readLine();             
    System.out.println("Received: " + clientSentence);             
    capitalizedSentence = clientSentence.toUpperCase() + '\n';              
    outToClient.writeBytes(capitalizedSentence);          
}