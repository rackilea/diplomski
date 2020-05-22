int delay =9;   // delay for 0 sec - start immediatelly
int period = 60000;  // repeat every 60 sec.
Timer timer = new Timer();

timer.scheduleAtFixedRate(new TimerTask() {
    public void run() {
        // Task here ...
    }
}, delay, period);