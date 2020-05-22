public void run() {
    try {
        String messageFromServer = reader.readLine();
        while (messageFromServer != null) {
            // Do things with messageFromServer here                               
            // processor.processFromServer(messageFromServer);
        messageFromServer = reader.readLine(); // Blocks the loop, waits for message
        }
    }
    catch (IOException e) {
            // Handle your exception
    }
}