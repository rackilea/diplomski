public static void main(String[] args) {
  TimerTask task = new MyTimerTask();
  Timer timer = new Timer();
  timer.scheduleAtFixedRate(task, 0, 1000);

  Runtime.getRuntime().addShutdownHook(new Thread(MyTimerTask::close));
}

public static class MyTimerTask extends TimerTask {

  public static void close() {
    resource.close(); 
  }

}