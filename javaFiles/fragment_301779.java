public class StuffExecutor {
  public abstract static class Listener {
    public abstract void success(String result);
    public abstract void failure(String reason);
  }

  private void stuff(Listener listener) {
    try {
      String result = doIt();
      listener.success(result);
    } catch (Throwable t) {
      listener.failure(t.getMessage());
    }
  }

  public void execute(final Listener listener) {
    new Thread(new Runnable() {
      public void run() {
        stuff(listener);
      }
    }).start();
  }
}