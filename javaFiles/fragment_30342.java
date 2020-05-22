public void startTimer() {
    timer = new Timer();
    time = 120;
    startTime = 30;
    counter = 0; // NEW CODE
    end = false;
    timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            counter++;
            time = startTime - counter;
            if (time == 0) {
                world.gameOver = true;
                end = true;
                timerCancel();
            }
        }
    }, 0, 1000);
}