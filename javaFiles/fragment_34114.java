public class UsingSharedInt {

       private BlockingQueue<Integer> q = new ArrayBlockingQueue<>(100);

       public void setSharedInt( int val )
       {
          System.err.println( Thread.currentThread().getName() +
          " setting sharedInt to " + val );
          q.add(val); // puts val into the queue
       }

       public int getSharedInt()
       {
         int val = q.take(); // waits for element to become available in queue, then returns one
         System.err.println( Thread.currentThread().getName() +
         " retrieving sharedInt value " + val);
         return val;
       }
   }