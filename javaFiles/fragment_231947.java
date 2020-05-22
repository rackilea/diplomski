private static MyObj obj;
private static final Object objLock = new Object();

public static MyObj getMyObj() {
    synchronized(objLock) {
        if (obj == null) {
            obj = new MyObj();
        }
        return obj;
    }
}