addRound();
sv.postDelayed(new Runnable() {

   @Override
   public void run() {
     sv.fullScroll(View.FOCUS_DOWN);
   }
}, 100);