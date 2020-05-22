Object lock = LockClass.getLock();
synchronized(lock){
    q.get(i);
    lock.notifyAll();
    lock.wait();    
}