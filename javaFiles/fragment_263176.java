RunnableFuture f = new FutureTask(new Callable<Boolean>() {
  // implement call
});
// start the thread to execute it (you may also use an Executor)
new Thread(f).start();
// get the result
f.get();