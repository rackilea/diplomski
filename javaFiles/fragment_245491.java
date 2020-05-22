Display.getDefault().timerExec(1000, new Runnable() {
   @Override
   public void run()
   {
     // TODO output one item to the log

     // TODO if need to run again call
     Display.getDefault().timerExec(1000, this);
   }
});