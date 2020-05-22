public class Producer<T> {

    public static void main(String[] args) throws InterruptedException {
        Producer<Integer> t1 = new Producer<> (Integer.class);
        Producer<Integer> t1 = new Producer<> (String.class); //does not compile
        Producer<String> t2 = new Producer<> (String.class);
        System.out.println(t1.get()); //prints 10
        System.out.println(t2.get()); //throws exception
    }

    private final Class<T> c;

    public Producer(Class<T> c) {
        this.c = c;
    }

    public T get() {
        if (c == Integer.class) {
            return (T) (Object) 10;
        }
        throw new UnsupportedOperationException();
    }
}