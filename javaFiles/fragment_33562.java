import java.util.*;

public class BrokenSet<E> extends HashSet<E> {
    private final List<E> list = new ArrayList<E>();

    public BrokenSet(Collection<? extends E> c) {
        super(c);
    }

    @Override public boolean add(E item) {
        if (super.add(item)) {
            list.add(item);
            return true;
        }
        return false;
    }
}