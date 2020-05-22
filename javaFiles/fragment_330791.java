class CommsThread implements Runnable {
      public void run() {
//         Socket s = null;

        ss = new ServerSocket(SERVERPORT );

         while(true) {
             try {


                 Socket socket = ss.accept();
                 Thread lThread = new Thread(new ListeningThread(socket));
                 lThread.start();

              } catch (IOException e) {
                 e.printStackTrace();
              }
         }


      }
   }