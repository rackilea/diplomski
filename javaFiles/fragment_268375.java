class Counter{
    final Object lock= new Object();
    int count;
    public void doCount(){
        synchronized (lock){
            count=count+1;
        }
    }
    public int getCount(){
        synchronized (lock) {
            return count;
        }
    }
}