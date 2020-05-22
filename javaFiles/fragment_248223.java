public class Trigger{
  private final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

  public void trigger(){
     queue.offer("foo");
  } 

  public void waitForTrigger(){
    queue.take();
  }
}