Timer timer = new Timer();
  long interval = (1000) ; // 1 sec

  timer.schedule( new TimerTask() {
       public void run() {
          //do your work;
       }
  }, 0, interval);