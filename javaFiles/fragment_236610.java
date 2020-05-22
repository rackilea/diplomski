private static final ConcurrentMap<String,Lock> dateLock = new ConcurrentHashMap<String,Lock>();

public static Lock getLock(Date date){ 
  String formattedDate = new SimpleDateFormat("MM\dd\yyyy").parse(date);
  Lock lock = dateLock.get(formattedDate);  
  if(lock == null){
    Lock lock = new ReentrantLock();  
    Lock temp =dateLock.putIfAbsent(lock); 
    lock = temp == null ? lock : temp;
  }
 return lock;
}