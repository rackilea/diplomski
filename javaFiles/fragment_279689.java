public class BinNode<T extends Comparable<T>> {
    private T element;
    private BinNode<T> left;
    private BinNode<T> right;

    public BinNode<T> find(T obj) {
        // TODO: Handle the cases where left or right is null
        if (element == null) {
            return null;
        } else if (obj.compareTo(left.element) < 0) {
            return left.find(obj);
        } else if (obj.compareTo(right.element) > 0) {
            return right.find(obj);
        } else {
            return this;
        }
    }

    public void insert(T obj) {

    }
}