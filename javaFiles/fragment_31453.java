public class IgnorableException {  

     static class DontIgnoreCount  {
         int count;
     }

     // Thread local variable containing each thread's ID
     private static final ThreadLocal<DontIgnoreCount> dontIgnoreCount =
         new ThreadLocal<DontIgnoreCount>();

     static void incrementDontIgnore() {
         DontIgnoreCount counter = dontIgnoreCount.get();
         if (counter == null) {
             counter = new DontIgnoreCount();
             dontIgnoreCount.set(counter);
         }
         counter.count++;
     }

     static void decrementDontIgnore() {
         DontIgnoreCount counter = dontIgnoreCount.get();
         // Must not be null here
         counter.count--;

     static bool shouldSignal() {
         DontIgnoreCount counter = dontIgnoreCount.get();
         return counter.count > 0;
     }
}