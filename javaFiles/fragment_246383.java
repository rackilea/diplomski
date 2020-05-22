public class A<T> extends MyMap<T> {
    public A() {
        super(new HashMap<>());
    }
}
public class B<T> extends MyMap<T> {
    public B() {
        super(new TreeMap<>());
    }
}