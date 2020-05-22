class Channel {
    final ReadWriteLock lock = new ReentrantReadWriteLock();

    void read(){
      lock.readLock().lock();
      try{

      }finally{
         lock.readLock().unlock();
      }
    }
    void write(){   
      lock.writeLock().lock();
      try{

      }finally{
         lock.writeLock().unlock();
      }
    }
}