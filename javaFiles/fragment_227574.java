class BinaryTree<E> {
  public BinaryTree<E> root() {
    if (parent == null) return this;
    else return parent.root();
  }
}

class ColorBinaryTree<E> extends BinaryTree<E> {
  @Override
  public ColorBinaryTree<E> root() {
    return (ColorBinaryTree<E>)super.root();
  }
}