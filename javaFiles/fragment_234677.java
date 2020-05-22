class MyThread implements Runnable, MessageListener{
          private Listen Listener;
          private Object lock = new Object();
      public MyThread(){
        Listener = new Listener(this);
      }

      public void run(){
        while(true){
            synchronized (lock) {
                try{
                    lock.wait();
                    // use the updated status
                }catch (Exception e) {
                    e.printStackTrace()
                }
            }
        }
      }

      public void messageReceived(Message m){
          synchronized (lock) {
                try{
                    // Do something with the message here like update some status
                    lock.notify();                      
                }catch (Exception e) {
                    e.printStackTrace()
                }

      }
    }