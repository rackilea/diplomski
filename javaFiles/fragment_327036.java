map.put(0, new CustomRunnable<Foo,Bar>() {
  public void run(Foo arg1, Bar arg2) {
    doSomeFunction(arg1);
  }
});
map.put(1, new CustomRunnable<Foo,Bar>() {
  public void run(Foo arg1, Bar arg2) {
    doSomeOtherFunction();
  }
});
map.put(2, new CustomRunnable<Foo,Bar>() {
  public void run(Foo arg1, Bar arg2) {
    doStuff(arg2);
  }
});