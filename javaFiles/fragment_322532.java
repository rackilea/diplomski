public Void doInBackground() throws Exception {
  // Define executor service containing exactly nThreads threads.
  ExecutorService execService = Executors.newFixedThreadPool(nThreads);


  // Define completion service that will contain the processing results.
  CompletionService compService = new ExecutorCompletionService(execService);    

  // Submit work to thread pool using the CompletionService.  Future<String>
  // instances will be added to the completion service's internal queue until complete.
  for (int i=0; i<nThreads; ++i) {
    compService.submit(new MyCallable());
  }

  // Take results from each worker as they appear and publish back to Swing thread.
  String result;
  while ((result = compService.take().get()) != null) {
    publish(result);
  }
}