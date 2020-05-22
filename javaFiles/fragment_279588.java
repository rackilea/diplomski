import java.util.function.Consumer;

public class ArrayWrapper {

    private Consumer consumer;

    private Object [] array;

    public ArrayWrapper(int size) {
        this.array = new Object [size];
    }

    public void addConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public void add(Object o, int index) {
        array[index] = o;
        consumer.accept(o);
    }

    public Object [] get() {
        return array;
    }
}