private final Lock lck = new ReentrantLock();
private final Condition cnd = lck.newCondition();
private final AtomicBoolean threadwaiting = new AtomicBoolean(false);

public synchronized void trade(Thread thread)
{
    lck.lock();
    try{
    if(threadwaiting.get()){
      cnd.signalAll();
      threadwaiting.set(false);
      //perform your task
    }else{
      cnd.await();
      threadwaiting.set(true);
    }
    }
    } finally {
   lck.unlock()
 }

}