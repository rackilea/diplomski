import java.util.Vector;

public class SubClassArrayList<E> extends Vector<E> {

    public boolean add(E e , int length) {
        if (e instanceof Object[] && ((Object[]) e).length == length) {
            return super.add(e);
        }
        else return false;
    }

}