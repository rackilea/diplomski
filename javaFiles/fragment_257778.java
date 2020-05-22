public class Test {

 public void method() {
     final Object handle = new Object();

     Thread thread = new Thread() {
         public void run() {
             handle.toString();
         }
     };

     thread.start();
 }
}