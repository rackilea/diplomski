//Creates a pool of 5 concurrent thread workers
ExecutorService es = Executores.newFixedThreadPool(5);

//List of results for each row computation task
List<Future<Void>> results = new ArrayList<Future<Void>>();
try{
  for(int row=0; row<matrix.length; row++){
    final int workRow = row;

    //The main part. You can submit Callable or Runnable
    // tasks to the ExecutorService, and it will run them
    // for you in the number of threads you have allocated.
    // If you put more than 5 tasks, they will just patiently
    // wait for a task to finish and release a thread, then run.
    Future<Void> task = es.submit(new Callable<Void>(){
      @Override
      public Void call(){
        for(int col=0; col<matrix[workRow].length; col++){
          //do something for each column of workRow
        }
        return null;
      }
    });
    //Store the work task in the list.
    results.add(task);
  }
}finally{
  //Make sure thread-pool is shutdown and all worker
  //threads are released. 
  es.shutdown();
}

for(Future<Void> task : results){
  try{
    //This will wait for threads to finish. 
    // i.e. same as Thread.join()
    task.get();
  }catch(ExecutionException e){
    //One of the tasks threw an exception!
    throw new RuntimeException(e);
  }
}