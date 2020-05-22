public class BinaryTree<E extends Comparable<? super E>> {

    protected Node<E> root;

    @Override
    public String toString() {
        return "{"
                + (root == null ? "" : String.valueOf(this.root)) +
                "}";
    }

    // other methods

}