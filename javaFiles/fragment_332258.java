public class AVLNode<E extends Comparable<E>> {
    private E item;

    //...

    public int compareTo(final E obj) {
        return this.item.compareTo(obj);
    }