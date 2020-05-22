BlockingQueue<O> queue = ...

...

public void run() {
   try {
       // The following test is necessary to get fast interrupts.  If
       // it is replaced with 'true', the queue will be drained before
       // the interrupt is noticed.  (Thanks Tim)
       while (!Thread.interrupted()) {
           O obj = queue.take();
           doSomething(obj);
       }
   } catch (InterruptedException ex) {
       // We are done.
   }
}