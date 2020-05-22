public class Multiplexer<M> {
  private final List<BlockingQueue<M>> consumers 
    = new CopyOnWriteArrayList<BlockingQueue<M>>();

  public void publish(M msg) {
    for (BlockingQueue<M> q : consumers) {
      q.offer(msg);
    }
  }

  public void addConsumer(BlockingQueue<M> consumer) {
    consumers.add(consumer);
  }
}