try{
   ServerSocket serverSocket = new ServerSocket(1312);
   while(true) {
       serverSocket.accept();

       //Client connected
       Socket clientSocket = serverSocket.accept();

       //Socket read-write
       //Also it is better to delegate this client session to another thread
   }
}catch(IOException e) {
   e.printStackTrace();
}