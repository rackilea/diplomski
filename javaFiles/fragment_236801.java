if(startTimer == true) {
    cdt = new CountDownTimer(120000, 1000) {
        public void onTick(long millisUntilFinished) {
            maxTime = (int) (millisUntilFinished / 1000);
            timer.setText(String.valueOf(maxTime));
        }

        public void onFinish() {

        }
    }.start(); //start the countdowntimer
}
else{
    cdt.cancel();
}