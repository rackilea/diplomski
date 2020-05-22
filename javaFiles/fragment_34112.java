private Runnable runnable = new Runnable() {
   @Override
   public void run() {
      /* do what you need to do */
      foobar();
      /* and here comes the "trick" */
      handler.postDelayed(this, 3000);
   }