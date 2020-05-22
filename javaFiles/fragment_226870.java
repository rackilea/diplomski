// base functionality goes here, T is the element type, U is the node type
public abstract class Tree<T, U extends AbstractNode<T, U>> { ... }

public class BinarySearchTree<T> extends Tree<T, Node<T>> { ... }

public class RedBlackTree<T> extends Tree<T, RedBlackNode<T>> { ... }