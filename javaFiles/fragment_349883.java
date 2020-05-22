// global, shared lock.
final Lock lock = new ReentrantLock();
final Condition locationReceived  = lock.newCondition(); 

// first servlet:
//
lock.lock();
try {
    requestLocation();
    if (!locationReceived.await(10, TimeUnit.SECONDS)) {
        // location was not received in the timeout.
    } else {
        // read location from shared object.
    }
} finally {
    lock.unlock();
}


// servlet that receives geolocation
//
lock.lock();
try {
    // set location in shared object.
    locationReceived.signal();
} finally {
    lock.unlock();
}