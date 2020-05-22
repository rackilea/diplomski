public class ArrayListGeneric1<T> {
    private int capacity = 1;
    private int size = 0;
    private Object[] array = new Object[capacity];

    public ArrayListGeneric1() {}

    public T get(int i) {
      return (T) array[i];
    }

    public void set(int i, T element) {
      array[i] = element;
    }
}