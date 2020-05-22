public class Message
{
   private static final int CLIENT_PORT = 8000;

   // Externally provided:
   private final Client[] to;
   private final String contents;
   private final StatusListener listener;

   // Internal state:
   private final List<Socket> clientConnections;
   private final BlockingQueue<Status> statusQueue;

   public Message(Client[] to, String contents, StatusListener listener)
   {
      this.to = to;
      this.contents = contents;
      this.listener = listener;

      // Keep a list of socket references so that all threads can be closed:
      clientConnections = Collections.synchronizedList(new ArrayList<Socket>());

      // Initialise the statusQ for threads to report message status:
      statusQueue = new ArrayBlockingQueue<Status>(to.length * 3);
   }

   public void dispatch()
   {
      // Dispatch to each client individually and wait for confirmation:
      sendContentsToEachClientAsynchronously();

      Status statusChangeReceived;

      do {
         try {
            // Now, monitor queue and empty the queue as it fills up (consumer):
            statusChangeReceived = statusQueue.take();
         }
         catch (InterruptedException ignore) {
            break;
         }
      }
      while (listener.updateStatus(statusChangeReceived));

      closeRemainingClientConnections();
   }

   private void closeRemainingClientConnections()
   {
      for (Socket connection : clientConnections) {
         try {
            connection.close();
         }
         catch (IOException ignore) {
            // OK
         }
      }

      clientConnections.clear();
   }

   private void sendContentsToEachClientAsynchronously()
   {
      for (Client client : to) {
         System.out.println("Started new thread");
         new Thread(new MessageDispatcher(client)).start();
      }
   }

   // One MessageDispatcher per client.
   private final class MessageDispatcher implements Runnable
   {
      private final Client client;

      MessageDispatcher(Client client) { this.client = client; }

      public void run()
      {
         try {
            communicateWithClient();
         }
         catch (IOException e) {
            throw new RuntimeException(e);
         }
      }

      private void communicateWithClient() throws IOException
      {
         // Open connection to client:
         Socket connection = new Socket(client.getAddress(), CLIENT_PORT);

         try {
            // Add client connection to synchronized list:
            clientConnections.add(connection);

            sendMessage(connection.getOutputStream());
            readRequiredReceipts(connection.getInputStream());
         }
         finally {
            connection.close();
         }
      }

      // Send message and confirm dispatch.
      private void sendMessage(OutputStream output)
      {
         PrintWriter out = new PrintWriter(output, true);

         out.println(contents);
         statusQueue.add(new Status(client, "DISPATCHED"));
      }

      private void readRequiredReceipts(InputStream input) throws IOException
      {
         BufferedReader in = new BufferedReader(new InputStreamReader(input));

         // Wait for display receipt:
         in.readLine();
         statusQueue.add(new Status(client, "DISPLAYED"));

         // Wait for read receipt:
         in.readLine();
         statusQueue.add(new Status(client, "READ"));
      }
   }
}