void setOff() {
  final FutureTask<Boolean> ft = new FutureTask<Boolean>(new myClass());
  new Thread(ft).start();
  try {
    System.out.println("The result is: " + ft.get());
  } catch (ExecutionException e) {
    System.err.println("A method executed on the background thread has thrown an exception");
    e.getCause().printStackTrack();
  }
}

class myClass implements Callable<Boolean> {
  @Override public Boolean call() throws Exception {
    // let's fake some long running computation:
    Thread.sleep(1000);
    return true;
  }
}