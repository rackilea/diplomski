try{
    server = new ServerSocket(sockNum);
    server.setSoTimeout(timeOut);
} catch (IOException e) {
    System.out.printf("Could not listen on port %d\n",sockNum);
    System.exit(-1);
}

while(isActive){
    ClientWorker w;
    try{
        Socket connection = server.accept();
        w = new ClientWorker(connection);
        Thread t = new Thread(w);
        t.start();
    } catch (IOException e) {
        if(e instanceof SocketTimeoutException)
            isActive = false;
        else{
            System.out.printf("Accept failed: %d\n",sockNum);
            System.exit(-1);
        }
    }
}

 class ClientWorker implements Runnable {
        private Socket client;
        private Source source = Source.NONE;
        private String sourceName = "?";
        private Boolean threadActive = true;

        ClientWorker(Socket client) {
            this.client = client;
        }

        public void run(){
            Object line;
            ObjectInputStream in = null;
            PrintWriter out = null;
            try{
                in = new ObjectInputStream(client.getInputStream());
                out = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("in or out failed");
                System.exit(-1);
            }

            while(threadActive){
                try{
                    line = in.readObject();
                    if(line instanceof String){
                        if(line.equals("end")){
                            threadActive = false;
                        }else
                            sourceName = line;
                        }
                    } else 
                        handleData;
                } catch (IOException e) {
                    System.out.println("Read failed");
                    threadActive = false;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    threadActive = false;
                }
            }
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }