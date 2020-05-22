import java.util.SortedSet;

public abstract class BinarySearchTree<T extends Comparable<T>> implements SortedSet<T> {
  private Node<T> root;

  class Node<T extends Comparable<T>> {

    private T key;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T key, Node<T> leftChild, Node<T> rightChild) {
      this.setKey(key);
      this.setLeftChild(leftChild);
      this.setRightChild(rightChild);
    }

    public void setKey(T key) {
      this.key = key;
    }

    public T getKey() {
      return key;
    }

    public void setParent(Node<T> y) {
      this.parent =  y;
    }

    public Node <T> getParent() {
      return parent;
    }

    public void setLeftChild(Node <T> leftChild) {
      this.leftChild = leftChild;
    }

    public Node <T> getLeftChild() {
      return leftChild;
    }

    public void setRightChild(Node <T> rightChild) {
      this.rightChild =  rightChild;
    }

    public Node <T> getRightChild() {
      return rightChild;
    }
  }

  public void insert(Node<T> z) {

    Node<T> y = null;
    Node<T> x = root;

    while (x != null) {
      y = x;

      if (z.getKey().compareTo(x.getKey()) < 0) {
        x = x.getLeftChild();
      } else {
        x = x.getRightChild();
      }
    }

    z.setParent(y);

    if (y == null) {
      root = z;
    } else if (z.getKey().compareTo((T) y.getKey()) <0) {
      y.setLeftChild(z);
    } else {
      y.setRightChild(z);
    }
  }
}