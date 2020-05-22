java.util.TimerTask timerTask = new java.util.TimerTask() {
    @Override
    public void run() {
        //change button text here using button.setText("newText"); method
    }
};

java.util.Timer myTimer = new java.util.Timer();
myTimer.schedule(timerTask, 3 * 1000, 3* 1000); // This will start timer task after 3 seconds and repeat it on every 3 seconds.