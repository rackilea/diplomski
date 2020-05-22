public interface Tree<
  T,
  TNode extends Node< T >
>
{

    void setRoot(TNode root);

    TNode getRoot();

    List<TNode> postOrder();

    ... rest omitted ...
}