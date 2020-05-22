Object lock = LockClass.getLock();
synchronized(lock){
    q.put(i);
    lock.notifyAll();
    lock.wait();    
}