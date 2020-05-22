public class myClass {
   public static void myFunc() {
      // bunch of code that doesn't need to be thread safe.
      synchronized(MyClass.class) {
         // Code that needs to be thread safe.
      }
      // More code that doesn't need thread safety.
   }
}