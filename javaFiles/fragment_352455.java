import java.util.*;
import com.google.common.collect.*;

public class ListWithDefault<E> extends ForwardingList<E> {
    final E defaultValue;
    final List<E> delegate;

    ListWithDefault(List<E> delegate, E defaultValue) {
        this.delegate = delegate;
        this.defaultValue = defaultValue;
    }
    @Override protected List delegate() {
        return delegate;
    }
    @Override public E get(int index) {
        E v = super.get(index);
        return (v == null ? defaultValue : v);
    }
    @Override public Iterator<E> iterator() {
        final Iterator<E> iter = super.iterator();
        return new ForwardingIterator<E>() {
            @Override protected Iterator<E> delegate() {
                return iter;
            }
            @Override public E next() {
                E v = super.next();
                return (v == null ? defaultValue : v); 
            }
        };
    }
}