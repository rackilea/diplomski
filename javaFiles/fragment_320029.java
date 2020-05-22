executor.execute(new MyRunnable(i));


class MyRunnable implements Runnable {
     int i;

     public MyRunnable(int i) {
         this.i = i;
     }

     // run method
 }