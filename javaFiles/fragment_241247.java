...
public E next() {
    checkForComodification();
    int i = cursor;
    if (i >= SubList.this.size)
        throw new NoSuchElementException();
    Object[] elementData = ArrayList.this.elementData;
    if (offset + i >= elementData.length)
        throw new ConcurrentModificationException();
    cursor = i + 1;
    return (E) elementData[offset + (lastRet = i)];
}

public void add(E e) {
    checkForComodification();

    try {
        int i = cursor;
        SubList.this.add(i, e);
        cursor = i + 1;
        lastRet = -1;
        expectedModCount = ArrayList.this.modCount;
    } catch (IndexOutOfBoundsException ex) {
        throw new ConcurrentModificationException();
    }
}