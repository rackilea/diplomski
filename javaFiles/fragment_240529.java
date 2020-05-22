public class myClass {
   public void myFunc() {
      // bunch of code that doesn't need to be thread safe.
      synchronized(this) {
         // Code that needs to be thread safe per instance
      }
      // More code that doesn't need thread safety.
   }
}