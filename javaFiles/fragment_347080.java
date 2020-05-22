public class Whatever<T> {
    public void foo(T e) {
    }

    public static void main(String[] args) {
        Whatever<? extends Number> w = new Whatever<Integer>();
        w.foo(new Integer(4)); // won't compile
    }
}