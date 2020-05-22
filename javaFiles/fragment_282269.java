List<Semaphore> acquired = new ArrayList<>(2);
while(!Thread.currentThread().isInterrupted) { 
  try{
    A.acquire(2);
    acquired.add(A);
    B.acquire(2);
    acquired.add(B);
    //some-stuff
  } catch(InterruptedException ex){}
  finally{ 
    for (Semaphore s : acquired) {
      s.release(2);
    }
    s.clear();
  }
}