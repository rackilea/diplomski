import java.util.ArrayList;

public class LimitedCollection<E> extends ArrayList<E> {

    public static final int MAX_ELEMENTS = 2;

    @Override
    public boolean add(E e) {
        if (this.size() < MAX_ELEMENTS) {
            return super.add(e);
        } else {
            return false;
        }
    }
    }