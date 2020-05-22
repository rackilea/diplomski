new CountDownTimer(5000, 1000) {

     public void onTick(long millisUntilFinished) {
         b.setText("Seconds remaining: " + millisUntilFinished / 1000);
     }

     public void onFinish() {
         b.setText("Time up");
         b.setEnabled(false);
         // Showing user clicks after button is disabled
         showClicks();
     }
  }.start();