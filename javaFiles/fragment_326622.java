final long maxWait = 1000;
final int maxMessages = 10;
final ArrayBlockingQueue<Message> queue;

final Thread aggregator = new Thread()
{
  @Override
  public void run() {
    try {
      ArrayList<Message> messages = new ArrayList<>();
      while ( true ) {
        messages.clear();
        queue.drainTo( messages );

        // Store messages

        this.wait( maxWait );
      }
    }
    catch ( InterruptedException e ) {
      // Handle this..
    }
  }
};

final Thread reciever = new Thread()
{
  @Override
  public void run() {
    Message message; // Get this from network
    queue.put( message );
    if(queue.size() > maxMessages) {
      aggregator.notify();
    }
  }
}