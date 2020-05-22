Handler handler = new Handler();
Runnable runable = new Runnable({
   @Override
   public void run(){
        // count
        handler.postDelayed(this, 1000);
   }
});