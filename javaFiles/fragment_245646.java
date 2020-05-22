class MyThread implements Runnable{
       Thread t;
       int delay;
       MyThread (int delay) {
          t = new Thread(this,"My thread");
          this.delay = delay;
          t.start();
       }
       public void run() {
          for(int x=0; x<100; x++)
          {
           Print("Loop number: " + x);
           TimeDelay(delay);
          }
      }
    }
    class Demo {
       public static void main (String args[]){
         Thread t1 = new MyThread(2);
         Thread t2 = new MyThread(2);
         t1.join();
         t2.join();    
       }
    }