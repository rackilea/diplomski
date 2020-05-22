TextView TimerBox;
long startTime = 0;

Handler timerHandler = new Handler();

//this updates the textbox
Runnable timerRunnable = new Runnable() {
    @Override
    public void run() {
        long millis = System.currentTimeMillis() - startTime;
        int seconds =  (int) (millis / 1000);
        int decis = (int) ((millis % 1000)/10);

        TimerBox.setText(String.format("Time: %d.%02d", seconds, decis));
        timerHandler.postDelayed(this, 10);
    }
};