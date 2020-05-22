class MyMap extends ConcurrentHashMap{
  val lock = new ReentrantReadWriteLock();  

  def addEntry(key: String, newList: immutable.List[String]) = {
    lock.readLock.lock()

    //if key exist,appending the newList to the exist one 
    //otherwise set the newList as the value
    this.putIfAbsent(key, new List())
    this(key).synchronized{
        this(key) += newList
    }

    lock.readLock.unlock()
  }

  def resetEntry(key: String, currentBatchSize: Int): Unit = {
    lock.writeLock.lock()

    this.remove(key)

    lock.writeLock.unlock()
  }
}