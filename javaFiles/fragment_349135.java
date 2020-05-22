import java.util.Arraylist;
import java.util.Objects;
import java.lang.reflect.Array;

public class TypedList<E> extends ArrayList<E> {
    private final Class<E> e;

    public TypedList(Class<E> e) {
        this.e = Objects.requireNonNull(e);
    }

    @Override
    public E[] toArray() {
        @SuppressWarnings("unchecked")
        final E[] arr = (E[])Array.newInstance(e, size());
        return toArray(arr);
    }
}