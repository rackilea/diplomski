synchronized(lock)
  {
           lock.notifyAll();
           while(condition)
                lock.wait();
  }