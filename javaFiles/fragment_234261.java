if (_instance == null) {                // L1
    synchronized (Singleton.class) {    // L2
        if (_instance == null) {        // L3
            _instance = new Singleton();// L4
        }
    }
}