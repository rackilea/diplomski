display.timerExec(100, new Runnable() {
  @Override
  public void run() {

     // TODO update UI from background thread details

     // Run again
     display.timerExec(100, this);
  }
});