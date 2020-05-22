public class Example {
  private final Object statusLock = new Object();
  private Integer status;

  public Example(Integer status) {
    this.status = status;
  }

  public void setStatus(Integer newStatus) {
    synchronized (statusLock) {
      status = newStatus;
    }
  }


  public Integer getStatus() {
    return status;
  }
}