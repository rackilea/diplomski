class RandomStack<E> extends Stack<E> {

    void addRandom(E e) {
        add((int) (Math.random() * (size() + 1)), e);
    }
}