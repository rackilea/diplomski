Timer timer = new Timer(new Runnable() {
    @Override
    public void run() {
        // code to run in each tick of the timer here...
    }
 }, someInterval, true);
// the timer will start automatically if you pass true as the third argument.