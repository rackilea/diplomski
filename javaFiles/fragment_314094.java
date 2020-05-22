class Foo {
  private Process p;

  Runnable runnable = new Runnable() {
    public void run() {
      ProcessBuilder pBuilder = new ProcessBuilder(...);  // fill in ...!
      // swallow or use the process's Streams!
      p = pBuilder.start();
    }
  }

  public Foo() {
    new Thread(runnable).start();
  }
}