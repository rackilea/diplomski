public static void main(String[] args) {
   Thread thead = new Thread(new myRunner());
   thread.start();
}



public class myRunner implements Runnable {

      @Override
      public void run() {
         // Do this in the background -- your for loop goes here
      }

 }