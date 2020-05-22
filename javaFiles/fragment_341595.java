Handler h = new Handler();
h.postDelayed(new Runnable() {
   public void run() {
       gameConstraintLayout.removeView(currentBullet);
   }
}, 1000);  // here 1000 is delay in milliseconds (1sec)