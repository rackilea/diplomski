final Condition workCompleted = myLock.newCondition();
//...
myLock.lock();
try {
  final OtherThread otherThread = startOtherThread(myLock, workCompleted);
  while (otherThread.completed() == false) {
    workCompleted.await();
  }
} finally {
  myLock.unlock();
}

// other thread
doTheWork();
this.completed = true;
theLock.lock();
try {
  workCompleted.signal();
} finally {
  theLock.unlock();
}