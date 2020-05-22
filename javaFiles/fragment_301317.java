interface Stack<T> {
    void push(T t);
}

interface IntStack extends Stack<Integer> {
    void push(int i);
}