for (int i = 0; i < 1000; i++) {
  decSemaphore.acquire();
  counter.decrement();     
  System.out.println("decreamented");
  incSemaphore.release();
}