class ConcurrenRandomizingQueue<E> extends AbstractQueue<E> {
    static Random r = new Random();
    Queue<Entry> q = new PriorityBlockingQueue<Entry>();

    static class Entry implements Comparable<Entry> {
        Object e;
        int p;

        Entry(Object e) {
            this.e = e;
            this.p = r.nextInt();
        }

        public int compareTo(Entry e) {
            return Integer.compare(p, e.p);
        }
    }

    public boolean offer(E e) {
        return q.offer(new Entry(e));
    }

    public E poll() {
        Entry e = q.poll();
        if (e == null)
            return null;
        return (E) e.e;
    }

    public E peek() {
    Entry e = q.peek();
    if (e == null)
        return null;
    return (E) e.e;
    }

    public int size() {
        return q.size();
    }

    public Iterator<E> iterator() {
        return null; // TODO
    }
}