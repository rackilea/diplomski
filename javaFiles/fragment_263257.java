class FileReaderThread implements Runnable {
     ..
     public FileReaderThread (String fileName) {
          ....
     }
     public void run() {
         /read file
     }
 }

 public class MainClass {
       public static void main(..) {
            Thread t = new Thread(new FileReaderThread(...));
            t.start();
            ...
       }
 }