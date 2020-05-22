public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;

    LinearNode(T elem, LinearNode<T> node) {
        next = node;
        element = elem;
    }
}