final CountDownTimer myTimer = new CountDownTimer(10000, 5000) {
@Override
public void onFinish() {
    //DO SOMETHING AFTER 10 000 ms
    }

    @Override
    public void onTick(long millisUntilFinished) {
    //DO SOMETHING EVERY 5 000 ms until stopped
    }
}
myTimer.start() //Starts it
myTimer.cancel() //Stops it