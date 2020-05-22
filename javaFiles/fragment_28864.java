private final LoadingCache<Long, Lock> idLocks = CacheBuilder.newBuilder()
       .build(
             new CacheLoader<Long, Lock>() {
                   public Lock load(Long id) throws AnyException {
                       return new ReentrantLock();
                   }
             });

public void doSmth(Long id){
     Lock lock = prLocks.get(id); //always return not-null Lock
     if (lock.tryLock()){
          try {
             //some code here
          } finally {
             lock.unlock();
          }
     }
 }