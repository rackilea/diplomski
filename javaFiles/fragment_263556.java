Thread serverThread = new Thread(new Runnable() {

    @Override
    public void run() {                                 

    try { 
         serverSocketTCP = new ServerSocket(); 
         serverSocketTCP.setReuseAddress(true); 
         serverSocketTCP.bind(new InetSocketAddress(YourPort));

   while (status) {
        clientSocketTCP = serverSocketTCP.accept();

        BufferedReader bufferedReader = new BufferedReader(new 
        InputStreamReader(client.getInputStream()));

        OutputStream outputStream = client.getOutputStream();



     }
  } catch (Exception e) {
     e.printStackTrace();

   }
    });
serverThread.start();