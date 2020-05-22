private static final Object lock = new Object();
private static volatile YourObject instance;

public static YourObject getInstance() {
    YourObject r = instance;
    if (r == null) {
        synchronized (lock) {    // While we were waiting for the lock, another 
            r = instance;        // thread may have instantiated the object.
            if (r == null) {  
                r = new YourObject();
                instance = r;
            }
        }
    }
    return r;
}