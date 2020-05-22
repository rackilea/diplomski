final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
final Lock readLock = rwLock.getReadLock();
final Lock writeLock = rwLock.getWriteLock();

Map passiveCopy = new HashMap();
Map activeMap = new HashMap();

final Map<String,Object> pendingUpdates = new HashMap(); 

//Interactive requests (REST API)
Object lookup(String key) {

  readLock.lock();
  try {
     return activeMap.get(key);
  } finally {
    readLock.unlock();
  }
}

//Background thread processing the incoming messages.
//Messages are processed strictly sequentially
//i.e. no other message will be processed, until
//current handleMessage() invocation is completed
//(that is guaranteed by the message processing framework itself)
void handleMessage(Message msg) {

   //New updates go to the pending updates temporary map
   if(msg.type() == ADD) {
      pendingUpdates.put(msg.getKey(),msg.getValue()); 
   }


   if(msg.type() == COMMIT) {     
      //Apply updates to the passive copy of the map
      passiveCopy.addAll(pendingUpdates);

      final Map tempMap = passiveCopy;    

      writeLock.lock();

      try {
        passiveCopy = activeMap;
        activeMap = tempMap;
      } finally {
        writeLock.unlock();
      }

      // Update the now-passive copy to the same state as the active map:
      passiveCopy.addAll(pendingUpdates);
      pendingUpdates.clear();
   }

}