class SayHello extends TimerTask {
       public void run() {
           handler.post(new Runnable() {
               public void run() {
                   wijzigingenThread.start();
               }
           });
       }
   }