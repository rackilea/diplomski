public void run() {
    int updatesPerSecond = 5;
    /* The target time is the time each update should take.
     * You want the target time to be in milliseconds.
     * so 5 updates a second is 1000/5 milliseconds. */
    int targetTime = 1000 / updatesPerSecond;
    long currentTime;
    long lastTime = System.nanoTime();
    long elapsedTime;
    long sleepTime;

    while (running) {

        // get current time (in nanoseconds)
        currentTime = System.nanoTime();

        // get time elapsed since last update
        elapsedTime = currentTime - lastTime;
        lastTime = currentTime;

        // run your update
        update();

        // compute the thread sleep time in milliseconds.
        // elapsed time is converted to milliseconds.
        sleepTime = targetTime - (elapsedTime / 1000000000);

        // don't let sleepTime drop below 0
        if (sleepTime < 0) {
            sleepTime = 1;
        }

        // attempt to sleep
        try {
            Thread.sleep(sleepTime);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}