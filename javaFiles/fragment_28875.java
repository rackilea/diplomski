class RunnableUI implements Runnable {
  public void run() {
    UI ui = new UI();
    synchronized (ui.getLock()) {
      ui.update(20);
      ui.stop();
    }
  }
}