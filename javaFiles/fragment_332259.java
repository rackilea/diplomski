public class AVLNode<E extends Comparable<E>> implements Comparable<AVLNode<E>> {
    private E item;

    //...

    @Override
    public int compareTo(final AVLNode<E> other) {
        return this.item.compareTo(other.item);
    }
}