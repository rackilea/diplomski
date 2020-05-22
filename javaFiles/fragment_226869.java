public abstract class AbstractNode<T, U extends AbstractNode<T, U>> {
    ...
    public U getLeft() {
        ...
    }
    ...
}

// inherited getLeft() will return Node<T>
public class Node<T> extends AbstractNode<T, Node<T>> { ... }

// inherited getLeft() will return RedBlackNode<T>
public class RedBlackNode<T> extends AbstractNode<T, RedBlackNode<T>> { ... }