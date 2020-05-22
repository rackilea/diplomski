new CountDownTimer(10000, 1000) {

 public void onTick(long millisUntilFinished) {
     mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
 }

 public void onFinish() {
     strat your activity here.
 }