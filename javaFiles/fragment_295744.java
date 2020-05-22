public class TwoThreads {
  static final String FINISHED = "Finished";
  public static void main(String[] args) throws InterruptedException {
    // The queue
    final BlockingQueue<String> q = new ArrayBlockingQueue<String>(10);
    // The sending thread.
    new Thread() {
      @Override
      public void run() {
        String message = "Now is the time for all good men to come to he aid of the party.";
        try {
          // Send each word.
          for (String word : message.split(" ")) {
            q.put(word);
          }
          // Then the terminator.
          q.put(FINISHED);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
      }
      { start();}
    };
    // The receiving thread.
    new Thread() {
      @Override
      public void run() {
        try {
          String word;
          // Read each word until finished is detected.
          while ((word = q.take()) != FINISHED) {
            System.out.println(word);
          }
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
      }
      { start();}
    };
  }
}