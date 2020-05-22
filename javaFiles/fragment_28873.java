class UI {
  private static final Object LOCK = new Object();

  public Object getLock() {
    return LOCK;
  }

  public void update() {
    synchronized (getLock()) {
      // do something
    }
  }
  ...
}