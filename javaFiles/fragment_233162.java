java.util.concurrent.locks.Lock lock = Hazelcast.getLock ("mymonitor");
lock.lock ();
try {
// do your stuff
}finally {
   lock.unlock();
}