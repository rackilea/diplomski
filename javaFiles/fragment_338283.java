public T pop() {
    if(first == null) {
        throw new EmptyStackException("Invalid operation on empty stack");
    }

    T value = first.data;
    first = first.next;
    return value;
}