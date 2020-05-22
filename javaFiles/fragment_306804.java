Object newLock = new Object();
Object oldLock = map.putIfAbsent(id, newLock);
Object lock = oldLock != null ? oldLock : newLock;
synchronized(lock) { 

}