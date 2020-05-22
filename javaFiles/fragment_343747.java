PrivateLock myPrivateLock = new PrivateLock();
// MyPrivateLockThread is a custom Thread class that calls myMethod
Thread thread = new MyPrivateLockThread(myPrivateLock);
thread.start();
// Now the following would be possible if the lock wasn't private
synchronized(myPrivateLock.myLock) { while (true) { } }