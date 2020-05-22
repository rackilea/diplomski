bool isUpdated = true;

countDownTimer = new CountDownTimer(20*60*100, 20*60*100) {
    @Override public void onTick(long millisUntilFinished) {
}

    public void onFinish() {
     isUpdated = false;
   }