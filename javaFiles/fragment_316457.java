runOnUiThread(new Runnable() {
   @Override
   public void run() {
      btn.setText(someValue);
   }
});