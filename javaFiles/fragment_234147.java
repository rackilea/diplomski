int initialDelay = 1000; // start after 1 seconds
    int period = 1000;        // repeat every 1 seconds
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      public void run() {
         if (toChange.length() > 10) {
            toChange = "";
        }
        Random rand = new Random();
        toChange += rand.nextInt(10);
    };
    timer.scheduleAtFixedRate(task, initialDelay, period);