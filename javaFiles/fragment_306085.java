public interface IntStack {
    void push(int value);
    int pop() throws InterruptedException;
}

public class DynamicStack implements IntStack {
    private int size = 0, stack[];

    public DynamicStack() {
        this(16);
    }

    public DynamicStack(int capacity) {
        stack = new int[capacity];
    }

    @Override
    public synchronized void push(int item) {
        if (size + 1 == stack.length)
            stack = Arrays.copyOf(stack, stack.length * 2);
        stack[size++] = item;
        notifyAll(); // notify() would also do.
    }

    @Override
    public synchronized int pop() throws InterruptedException {
        while (size == 0)
            wait();
        return stack[--size];
    }
}