new CountDownTimer(30000, 1000) {

     public void onTick(long millisUntilFinished) {
         Log.e("myapp","tick");
     }

     public void onFinish() {
         Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
         CurrentActivity.this.startActivity(myIntent);
     }
  }.start();