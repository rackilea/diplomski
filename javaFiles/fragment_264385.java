if (clientSentence.contains("BREW")) {
    outToClient.println("Message: " + clientSentence);
    outToClient.println("HTCPCP-new 200 OK BREW START command completed.");
    outToClient.println("Content-length:  " + clientSentence.length()); 
    outToClient.println("@@");
    outToClient.flush();
} else {
    outToClient.println("Message: " + clientSentence);
    outToClient.println("HTCPCP-new 400 Bad Request.");
    outToClient.println("Content-length:  " + clientSentence.length()); 
    outToClient.println("@@");
    outToClient.flush();
}