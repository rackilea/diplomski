class Main {
  public static void main(String[] args) {
    new firstThreadImplementation().start();
    // new secondThreadImplementation().start();
    new initGuiThread().start();
    // we are finished here and don't need this thread anymore
  }
}