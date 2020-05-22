public final CustBlockingQueue<BotMessage> msgQueue = new CustBlockingQueue<BotMessage>(1);


     // A consumer thread
     new Thread(new Runnable() {
         public void run() {
             while (true)
                 try {
                     // Blocks until there is something in the queue
                     BotMessage msg = msgQueue.take();
                     sendRawLine("PRIVMSG " + msg.getChannel() + " :" + msg.getMessage());
                     //Release lock so that put() unblocks
                     msgQueue.lock.lockInterruptibly();
                     msgQueue.doneProcessing.signal();
                     msgQueue.lock.unlock();
                     //Wait before continuing
                     Thread.sleep(Controller.msgWait);
                 } catch (InterruptedException e) {
                     log.error("Wait for sending message interrupted", e);
                 }
         }
     }).start();

 public class CustBlockingQueue<E> extends ArrayBlockingQueue<E> {
     public ReentrantLock lock = new ReentrantLock(false);
     public Condition doneProcessing = lock.newCondition();

     public CustBlockingQueue(int capacity) {
         super(capacity);
     }

     public void put(E e) throws InterruptedException {
        lock.lockInterruptibly();
        super.put(e);
        doneProcessing.await();
        lock.unlock();
    }
}