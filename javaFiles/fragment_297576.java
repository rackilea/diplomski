class Node<T> {
  private Node<T> next;
  private T data;

  public Node<T> getNext () {
    return next;
  }

  public T getData () {
    return data;
  }
}