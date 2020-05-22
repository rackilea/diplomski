Map<Integer, Runnable> map = ...;
map.put(0, new Runnable() {
  public void run() {
    doSomeFunction();
  }
});

map.get(0).run();