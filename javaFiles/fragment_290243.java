class Counter{
    private int count = 0;

    public int getCount(){
        return count;
    }

    public synchronized void increment(){
        count++;
    }

    public void reset(){
        count = 0;
    }
}