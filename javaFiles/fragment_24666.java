public class Producer<T> {

    public static void main(String[] args) throws InterruptedException {
        Producer<Integer> t1 = new Producer<> ();
        Producer<String> t2 = new Producer<> ();
        System.out.println(t1.get(Integer.class)); //prints 10
        System.out.println(t1.get(String.class)); //does not compile
        System.out.println(t2.get(String.class)); //throws exception
    }

    public T get(Class<T> c) {
        if (c == Integer.class) {
            return (T) (Object) 10;
        }
        throw new UnsupportedOperationException();
    }
}