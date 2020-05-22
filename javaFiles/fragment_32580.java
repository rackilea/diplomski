public class StackX {
    private final int maxSize;
    private final long[] stackArray;
    private int top;

    public StackX(final int size) {
        maxSize = size;
        stackArray = new long[maxSize];
        top = -1;
    }

    /** Puts an item on top of the stack. */
    public void push(final long value) {
        if (isFull()) {
            throw new UnsupportedOperationException("Stack is full");
        }

        stackArray[++top] = value;
    }

    /** Takes an item from top of the stack. */
    public long pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Stack is empty");
        }

        return stackArray[top--];
    }

    /** Peeks an item at top of the stack. */
    public long peek() {
        return stackArray[top];
    }

    /** Returns {@code true} if stack is empty. */
    public boolean isEmpty() {
        return top == -1;
    }

    /** Returns {@code true} if stack is full. */
    public boolean isFull() {
        return top == maxSize - 1;
    }
}