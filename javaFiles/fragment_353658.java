t = new Timer();
  task = new TimerTask() {
       @Override
       public void run() {
           // do periodical action <-------------
       }
  };
  t.scheduleAtFixedRate(task, 0, 1000);