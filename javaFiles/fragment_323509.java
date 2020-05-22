boolean success;
Thread httpThread = new Thread(new Runnable() {
  @Override
  public void run() {
    success = false;
    ....