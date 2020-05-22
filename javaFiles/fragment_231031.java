private Object writerLock = new Object();

xyz(...) {
    //same as in your example
}

private ... read(...) {
    ...
}

private ... write(...) {
    synchronized(writerLock) {
        ...
    }
}