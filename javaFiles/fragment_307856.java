public String aLotOfWork() {

  FutureTask task = new FutureTask<String>(new Callable<String>() {

    public String call() {
       return hardwork();
    }
  });

  try {
     return task.get(30, TimeUnit.SECONDS);
  } catch(TimeoutException e) {
     return "Timeout";
  }
  catch(Exception e) {
     return "Timeout"; // or whatever you like
  }

}