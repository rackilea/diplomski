// implement Runnable so it can be run in a background thread
public class MultiServer2 implements Runnable {
   public static final int PORT_NUMBER = 2222;
   private static final int THREAD_POOL_COUNT = 20;
   private List<MultiClientHandler> clientList = new ArrayList<>();
   private ServerSocket serverSocket;
   private ExecutorService clientExecutor = Executors.newFixedThreadPool(THREAD_POOL_COUNT);

   public MultiServer2() throws IOException {
      serverSocket = new ServerSocket(PORT_NUMBER);
   }

   @Override
   public void run() {
      // do this in the run method so that it runs in a background thread
      while (true) {
         try {
            Socket clientSocket = serverSocket.accept();

            // MultiClient2 also implements Runnable
            MultiClientHandler client = new MultiClientHandler(clientSocket);
            clientList.add(client);

            // and each socket's code needs to be run in its own thread
            clientExecutor.execute(client);
         } catch (IOException e) {
            // TODO notify someone of problem!
            e.printStackTrace();
         }
      }
   }