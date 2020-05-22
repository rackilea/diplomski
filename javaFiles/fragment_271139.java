public class Producer implements Runnable {
    Thread thread;
    Queue queue;

    public Producer(Queue queue) {
       this.queue = queue;
    }

    public void start() {
       thread = new Thread(this);
       thread.start();
    }

    public void shutdown() {
       thread.interrupt(); // request a shutdown
       thread.join();      // make sure we wait until Producer.thread exits before this thread continues
    }

    public void run() {
        try {
           while( !Thread.isInterrupted() ) {
               SomeMessage message = produceAMessage();
               synchronized( queue ) {
                  queue.add( message );
                  queue.notifyAll();
               }
           }
        } catch( InterruptedException ex ) {
           System.out.println("Producer shutting down per request.");
        } finally {
           thread = null;
        }
    }
}

public class Consumer implements Runnable {
    Thread thread;
    Queue queue;

    public Consumer( Queue queue ) {
        this.queue = queue;
    }

    public void start() {
        thread = new Thread( this );
        thread.start();
    }

    public void shutdown() {
       thread.interrupt(); // request a shutdown
       thread.join();      // make sure we wait until Consumer.thread exits before this thread continues
    }

    public void run() {
        try {
           while( !thread.isInterrupted() ) {
               SomeMessage message = take();
               doSomethingWithMessage( message );
           }
        } catch( InterruptedException ex ) {
           System.out.println("Stop processing - consumer per request.");
        } finally {
           thread = null;
        }
    }

    private SomeMessage take() throws InterruptedException {
       synchronized( queue ) {
           queue.wait();
           return queue.remove();
       }
    }
}