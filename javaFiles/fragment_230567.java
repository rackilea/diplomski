public interface Stack<T> {
    void push(T item); // adds an item to the stack
    T peek(); // looks what is the last item in the stack
    T pop(); // removes and returns the last item of the stack
    boolean isEmpty(); // are there items in the stack?
}