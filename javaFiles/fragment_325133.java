class BinaryTree<E extends Comparable<E>> implements Iterable<E> {   
    public void add(E toInsert) {
        // ...
    }

    public Iterator<E> iterator() {
        return null;
    }
}

class AVLTree<F extends Comparable<F>> extends BinaryTree<F> {  
    BinaryNode<F> theTree;
    @Override
    public void add (F toInsert)
    {
        // ...     
    }
}