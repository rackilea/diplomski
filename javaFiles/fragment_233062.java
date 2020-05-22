class fakenode<E extends Comparable<E>> implements Comparable<fakenode<E>> { // first change
    public E value;

    fakenode (E value)
    {
        this.value = value;
    }

    @Override
    public int compareTo(fakenode<E> o) { // second change
        value.compareTo(o.value);
        o.value.compareTo(value);

        return -1;
    }
}