public volatile Object helper;

public synchronized void initHelper() {
    Object result = new Object();
    helper = result;
}