public class myClass {
   static Object lock = new Object();
   public void myFunc() {
      // bunch of code that doesn't need to be thread safe.
      synchronized(lock) {
         // Code that needs to be thread safe across all instances.
      }
      // More code that doesn't need thread safety.
   }
}