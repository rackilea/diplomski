synchronized(lock){
  if(retryCount.get() < MAX_COUNT){
  // some other code
  retryCount.getAndIncrement();
  }else{
   // reset count & some other code
   retryCount.set(0);
  } 
}