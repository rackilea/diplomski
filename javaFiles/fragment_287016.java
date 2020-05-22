public static Person fromName(String name){
    ...
    synchronized (lock) {
        S1;
        S2;
    }
    ...
    return ...;
}