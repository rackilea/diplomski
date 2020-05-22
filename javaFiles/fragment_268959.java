class NoDupBlockingQueue<T> extends LinkedBlockingQueue<T> {

    Comparator<T> comp;

    public NoDupBlockingQueue(Comparator<T> comp) {
        this.comp = comp;
    }

    @Override
    public void put(T e) throws InterruptedException {
        for (T e2 : this)
            if (comp.compare(e, e2) == 0)
                return;
        super.put(e);
    }
}