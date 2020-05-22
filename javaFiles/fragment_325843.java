public abstract class BstTree<T extends Comparable,N extends BstNode<T,N>> {
    private N root;
...

    public void addValue(T value)
    {
        N node = newNode(value);
        addNode(node);
    }

    public abstract N newNode(T value);

    public void addNode(N node)
    {
        // ...
    }
}

public class BstNode<T extends Comparable,N extends BstNode<T,N>>
{
    private T value;
    private N parent = null;
    private N leftChild = null;
    private N rightChild = null;

    public BstNode(T value) {
        this.value = value;
    }

    public N getOnlyChild(N node)
    {
        // ...
    }
...
}

public class AVLTree<T extends Comparable> extends BstTree<T,AVLNode<T>> {
    ...
    @Override
    public AVLNode<T> newNode(T value) {
        return new AVLNode<>(value);
    }
}

public class AVLNode<T extends Comparable> extends BstNode<T,AVLNode<T>> {
    ...

    public AVLNode(T value) {
        super(value);
    }

    @Override
    public AVLNode<T> getOnlyChild(AVLNode<T> node) {
        return super.getOnlyChild(node);
    }
    ...
}