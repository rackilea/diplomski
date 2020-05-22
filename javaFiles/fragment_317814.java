class A {}
class B extends A {}

class Generic<T> {
    private T instance;
    public Generic(T instance) {
        this.instance = instance;
    }
    public T get(){ return instance; }
}

public class Main {
    public static void main(String[] args) {
        fArray(new B[1], new Generic<A>(new A())); // <-- No error here
    }

    public static <T> void fArray(T[] a, Generic<? extends T> b) {
        List<T> list = new ArrayList<>();
        list.add(a[0]);
        list.add(b.get());
        System.out.println(list);
    }
}