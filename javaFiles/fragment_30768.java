public class Example<T> {
    private T[] array = (T[]) new Object[5];

    public T[] getArray() {
        return array;
    }

    public static void main(String[] args) {
        Example<Integer> example = new Example<>();
        Integer[] foo = example.getArray(); // class cast exception
    }
}