Thread createThread(final Runnable r) {
  return new Thread(new Runnable() {
    @Override public void run() {
      try {
        r.run();
      } finally {
        Foo.decrementCounter();
      }
    }
  });
}