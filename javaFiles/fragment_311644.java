Timer startTimer(final int value, final long time) {
   Timer timer = new Timer("Timer" + value);
   timer.schedule( new TimerTask() {
            public void run() {
                // Code here
                System.out.println(value + " Event run");
            }
         }, 0, time); // Every second
   return timer;
}

Timer t0 = startTimer(0,1000);
Timer t1 = startTimer(1,1000);

// stop t0
t0.cancel();