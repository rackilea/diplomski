private void startTimer(){
    mCountDownTimer = new CountDownTimer(timeLeftToLive, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            timeLeftToLive = millisUntilFinished;
            updateTextView();
        }

        @Override
        public void onFinish() {

        }
    }.start();
}