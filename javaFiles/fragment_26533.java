public void run() {
    try {
        // create object to send information to client    
        PrintWriter out = new  PrintWriter(client.getOutputStream(),true);
        out.println("Student name: ");//send text to client;
    } catch (IOException e) {
       throw new RuntimeException("It all went horribly wrong!", e);
    }
}