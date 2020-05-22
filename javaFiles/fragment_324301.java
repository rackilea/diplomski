private CountDownLatch latch;

public PublisherThread(CountDownLatch latch){
    this.latch = latch;
}

public void run(){
  try{
      // kafka business logic
      // ....
  } finally {
      // you don't want your program to hang in case of an exception 
      // in your business logic
      latch.countDown();
  }
}