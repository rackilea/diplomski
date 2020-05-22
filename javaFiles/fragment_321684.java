new CountDownTimer(timeToBlow, timeToTick) {

 public void onTick(long millisUntilFinished) {
     Log.d(TAG,"About to blow!!!");
 }

 public void onFinish() {
     Log.d(TAG,"BOOM!");
 }
}.start();