addRound();
sv.post(new Runnable() {

   @Override
   public void run() {
     sv.fullScroll(View.FOCUS_DOWN);
   }
});