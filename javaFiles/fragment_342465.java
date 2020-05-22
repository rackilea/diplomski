public class MyRunnable implements Runnable {
         @Override
         public void run() {
              // thread logic goes here
         }
    }

    Thread th = new Thread(new MyRunnable());
    th.start();