public void startServer() {
if(server == null) {
    System.out.println("no server");
}   
    while(true) {
    try {
     socket = server.accept(); 
    ConnectionThread thread =new ConnectionThread(socket);
    threads.add(thread);
    thread.start();      
    } catch (IOException e) {
        e.printStackTrace();
    }   

}