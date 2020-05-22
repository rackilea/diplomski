private Object writeLock = new Object();
class thread1 implements Runnable{
    public void run(){
        synchronized (writeLock) {
            //write very long text
        }
    }
}
class thread2 implements Runnable{
    public void run(){
        synchronized (writeLock) {
            //write very long text
        }
    }
}