private final static int BASIC_STOPWATCH_ID = 
  Audits.mapAudit("example.basicStopwatch");

  public void tryOut(){
    final Stopwatch stopwatch = Audits.getBasicStopwatch(BASIC_STOPWATCH_ID);
    stopwatch.start();
    doSomeWork();
    stopwatch.stop();
  }