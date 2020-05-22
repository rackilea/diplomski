abstract class AbstractBinaryTree<E, T extends AbstractBinaryTree<E,T>> {
  T parent;

  public T root() {
    if (parent == null) return (T)this;
    else return parent.root();
  }
}

class BinaryTree<E> extends AbstractBinaryTree<E, BinaryTree<E>>{
}

class ColorBinaryTree<E> extends AbstractBinaryTree<E, ColorBinaryTree<E> {
}