class ItemHolder<T> {
    private T item;
    public synchronized void produce(T item) {
        this.item = item;
        notify();
    }
    public synchronized T consume() {
        while (item == null) {
            wait();
        }
        T result = item;
        item = null;
        return result;
    }
}