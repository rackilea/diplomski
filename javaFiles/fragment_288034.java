String clientSentence;
while ((clientSentence = inFromClient.readLine()) != null) {
    System.out.println("Client sent: "+clientSentence);
    //process
    String capitalizedSentence = clientSentence.toUpperCase() + '\n';
    //write out line to socket
    outToClient.print(capitalizedSentence);
    outToClient.flush();
}