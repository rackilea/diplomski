Handler timerHandler = new Handler();
Runnable timerRunnable = new Runnable() {

    @Override
    public void run() {

        functionA()
    }timerHandler.postDelayed(this, 5000);
}
};