public class MyClass<T extends Comparable<T>> {
    T[] arr;

    public MyClass() {
        arr = (T[])new Object[0];
    }
}