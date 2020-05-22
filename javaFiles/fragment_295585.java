class RotatingQueue<E> {
    Object[] data; // can't do E[]
    final int maxSize;
    int size = 0; // starts empty
    int first = 0; // starts at the front, why not?

    RotatingQueue(int size) {
        this.maxSize = size;
        data = new Object[size];
    }

    E add(E e) {
        E old = (E)(data[first]);
        old[first++] = e;
        if(size < maxSize) size++;
        return old;
    }

}