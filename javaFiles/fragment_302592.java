public class Stack {
    private int[] storage;
    private int size;

    public Stack(int capacity) {
        super();
        storage = new int[capacity];
    }

    public void push(int number) {
        if(storage == null) return;
        if(size >= storage.length) throw new RuntimeException("Stack Overflow");

        storage[size] = number;
        ++size;
    }

    public int pop() {
        if(storage == null) throw new RuntimeException("No storage");
        if(size == 0) throw new RuntimeException("Stack Underflow");

        --size;
        return storage[size];
    }
}