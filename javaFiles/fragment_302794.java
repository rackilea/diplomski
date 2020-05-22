public class JoinInterruptedExceptionExample {
public static void main(String[] args) {
   final Thread workerThread = new Thread(new Runnable() {
     @Override
     public void run() {
        try {
           Thread.sleep(20000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
     }
   });
   workerThread.start();

   final Thread waitingThread = new Thread(new Runnable() {
     @Override
     public void run() {
        try {
           workerThread.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
     }
   });
   waitingThread.start();

   waitingThread.interrupt();

}
}