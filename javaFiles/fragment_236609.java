private static final ConcurrentMap<Long,Lock> dateLock = new ConcurrentHashMap<Long,Lock>();

public static Lock getLock(Date date){
  Lock lock = dateLock.get(date.getTime());  
  if(lock == null){
    Lock lock = new ReentrantLock();  
    Lock temp =dateLock.putIfAbsent(lock); 
    lock = temp == null ? lock : temp;
  }
 return lock;
}