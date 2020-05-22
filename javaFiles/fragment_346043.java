class Test1 implements Runnable {
  public void run() {
    boolean backoff = false;
    while(true) {
      if (backoff) {
        Thread.sleep (TIME_FOR_LONGER_BREAK);
        backoff = false;
      }
      System.out.println("I'm test class 1");
      try {
        // do important stuff here, use database and other critical resources
      }
      catch (SqlException se) {
       // code to delay the next loop
       backoff = true;
      }
      catch (Exception e) {
      }
      catch (Throwable t) {
      }
    }
  }
}