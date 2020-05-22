public class MyCallback {
  private Boolean processSuccess;
  private Boolean serviceSuccess;
  public synchronized void notifyProcessStart(boolean success) {
    this.processSuccess = success;
    this.notifyAll();
  }
  public synchronized void notifyServiceCheck(boolean success) {
    this.serviceSuccess = success;
    this.notifyAll();
  }
  public synchronized void waitForResult() {
    while(processSuccess == null || serviceSuccess == null) {
      this.wait();
    }
    // ... do something good
  }
}