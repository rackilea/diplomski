final Handler handler - new Handler();
TimerTask task = new TimerTask() {
     public void run() {
           handler.post(new Runnable() {
                 public void run(){
                     t2.start(); // after 30 sec 2d thread will be executed
                     t1.sleep(?) // ? = how long time?
                 }
           });
     }
};