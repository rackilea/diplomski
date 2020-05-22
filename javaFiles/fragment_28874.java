class RunnableUI implements Runnable {
  private final UI _ui;

  RunnableUI(UI ui) {
    _ui = ui;
  }

  public void run() {
    synchronized (_ui) {
      _ui.update(20);
      _ui.stop();
    }
  }
}