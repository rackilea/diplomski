public static void StartServer() {

            socket = new ServerSocket(Constants.PORT_NUMBER);  
            socket.setReuseAddress(true);
            Logger.Log("Waiting for first client");

            while(true){
                try {
                    arraySocket.add(socket.accept());
                    Logger.Log("New Client: " + arraySocket.get(count).getInetAddress().toString());
                    (new Thread(new ClientHandler(arraySocket.get(count)))).start();
                    count++;
                } catch (IOException e) {
                    Logger.Log("Server:IOException:e: " + e);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

}