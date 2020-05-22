long remainingMs = System.currentTimeMillis() - timeMs;
new CountDownTimer(remainingMs, 1000) {

     public void onTick(long millisUntilFinished) {
         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
     }

     public void onFinish() {
         mTextField.setText("done!");
     }

}.start();