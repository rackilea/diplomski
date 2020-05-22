public abstract class AbstractTree<
  T,
  TNode extends Node< T >
> implements Tree<T, TNode> {

  protected TNode root;

  protected AbstractTree(TNode root) {
    this.root = root;
  }

  ...
}