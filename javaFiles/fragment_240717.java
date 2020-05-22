SwingUtilities.invokeLater(new Runnable() {
  @Override
  public void run() {
    synchronized (lock) {
      // ... your calls to StdDraw here ...
    }
  }
});