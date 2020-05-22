class NoDupBlockingQueue<T> extends LinkedBlockingQueue<T> {
    @Override
    public void put(T e) throws InterruptedException {
        if (!contains(e))
            super.put(e);
    }
}