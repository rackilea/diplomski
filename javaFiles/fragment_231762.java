public class MyJob implements Runnable {
     private static final ThreadLocal < SlowObject > threadLocal = 
       new ThreadLocal < SlowObject > () {
         @Override protected SlowObject initialValue() {
           // construct and return your SlowObject 
         }
       };

     public void run() {
       // work with threadLocal.get()
     }
   }