@Override
public Iterator<A> iterator() {
    return new MyListIterator();
}

private class MyListIterator implements Iterator<A> {
    private Listelem current;

    private MyListIterator() {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
       return this.current.getSucessor != null;
    }

    @Override
    public A next() {
        A next       = this.current.getValue;
        this.current = this.current.getSuccessor();
        return next;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
    }
}