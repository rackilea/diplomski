Thread thread2 = new Thread(new Runnable() {

  @Override
  public void run() {

    Handler mainHandler = new Handler(context.getMainLooper());
    Runnable myRunnable = new Runnable() {
      @Override 
      public void run() {
        Intent i = new Intent(context, NextActivity.class);
        startActivity(i);
    }
    mainHandler.post(myRunnable);
};