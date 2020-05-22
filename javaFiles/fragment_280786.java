public class Foo<T> extends AbstractList<T> implements List<T> {

    @Override
    public <E> E[] toArray(E[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Error!");
    }

    ...
}