class BaseNode<T extends BaseNode<T>> {
    T parent;
}

class AVLNode extends BaseNode<AVLNode> {
}