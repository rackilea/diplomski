Timer timer = new Timer("clock timer", true);

timer.schedule(new UpdateTimerTask(), 1000l, 1000l);  // Run once a second


private class UpdateTimerTask extends TimerTask
{
  @Override
  public void run()
  {
    // Timer task runs in a background thread, 
    // so use Display.asyncExec to run SWT code in UI thread

    Display.getDefault().asyncExec(new Runnable() 
     {
       @Override
       public void run()
       {
         // TODO update the label
       }
     });  
  }
}