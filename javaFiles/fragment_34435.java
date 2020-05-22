class ReinsertionStack<E> extends Stack<E> {
    @Override
    public E push(E item) {
        this.remove(item);
        return super.push(item);
    }
}