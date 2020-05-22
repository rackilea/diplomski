private Timer timer = new Timer();
private TimerTask timerTask;
timerTask = new TimerTask() {
  @Override
  public void run() {
    //refresh your textview
  }
};
timer.schedule(timerTask, 0, 10000);