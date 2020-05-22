Semaphore semaphore = new Semaphore(1000);
ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()){
  protected void beforeExecute(Runnable r, Throwable t) { 
     semaphore.release();
  }
}

public void doSubmit(Runnable r){
  sempahore.acquire();
  executor.submit(r);      
}