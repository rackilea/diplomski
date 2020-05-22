public class Bar<T extends Comparable<T>> implements Foo<T> {

    private Foo<T> foo;

    public void add(T object) {
        foo.add(object);
    }
}