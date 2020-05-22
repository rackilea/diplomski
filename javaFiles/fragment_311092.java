public class Server extends Thread {

     ...

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket s = serverSocket.accept();
                (new FileSaver(s)).start();

            }
         } catch (Exception e) {
            e.printStackTrace();
         }
     }

    ...
}