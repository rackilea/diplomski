MyBlockingQueue {
  private MyBlockingQueue oldQueue
  private ArrayBlockingQueue newQueue

  ArrayBlockingQueue(int newCapacity, MyBlockingQueue _oldQueue) {
    oldQueue = _oldQueue
    newQueue = new ArrayBlockingQueue(newCapacity)
    E oldVal = null
    while(newQueue.remainingCapacity() > 0 && 
         (oldVal = oldPoll) != null)
      newQueue.put(oldVal)
  }

  boolean isEmpty() {
    (oldQueue == null || oldQueue.isEmpty) && newQueue.isEmpty 
  }

  void put(E e) {
    newQueue.put(e)
  }

  E take() {
    E oldVal = oldPoll
    if(oldVal != null) oldVal else newQueue.take
  }

  E poll() {
    E oldVal = oldPoll
    if(oldVal != null) oldVal else newQueue.poll
  }

  private E oldPoll() {
    // If you have more than one consumer thread, then use a temporary variable
    // for oldQueue - otherwise it might be set to null between the null check
    // and the call to poll
    if(oldQueue == null) null
    else {
      E oldVal = oldQueue.poll
      if(oldVal != null) oldVal
      else {
        oldQueue = null
        null
      }
    }
  }
}