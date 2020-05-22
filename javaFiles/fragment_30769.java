public class Example<T> {
    private T[] array;

    public Example(T[] a) {
        array = a;
    }

    public void set(int i, T x) {
        array[i] = x;
    }

    public static void main(String[] args) {
        Example<Integer> example = new Example<>(new Integer[5]);
        example.set(0, 1);
    }
}