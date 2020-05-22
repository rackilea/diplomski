public class Main {
     int a = 0;
     int[] values;
     int[] results;

     public Main() {
         // Init values array

         results = new int[N];
     }

     public int doStuff() {
         LinkedList<Thread> threads = new LinkedList<Thread>();

         for (final int i : values) {
             Thread t = new Thread() {
                 public void run() {
                     accumulate(foo(i));
                 }
             };

             threads.add(t);
             t.start();
          }

          for (Thread t : threads) {
              try {
                  t.join();
              } catch (InterruptedException e) {
                  // Act accordingly, maybe ignore?
              }
          }

          return a;
     }

     synchronized void accumulate(int v) {
          // Synchronized because a += v is actually
          //    tmp = a + v;
          //    a = tmp;
          // which can cause a race condition AFAIK
          a += v;
     }
 }