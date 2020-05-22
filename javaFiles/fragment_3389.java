public class DLNode<T> {
  private T element;
  private DLNode<T> next;
  private DLNode<T> previous;

  public DLNode(T element, DLNode<T> previous, DLNode<T> next) {
     /* You need to write the correct code here to create a correctly formed 
     double linked list */
    this.element = element;
    if (next != null) {
      next.setPrevious(this);
      this.next = next;
    }
    if (previous != null) {
      previous.setNext(this);
      this.previous = previous;
    }
    if (previous == null) {
      this.previous = previous;
    }
    if (next == null) {
      this.next = next;
    }
  }

  public T getElement() {
    return element;
  }

  public DLNode<T> getNext() {
    return next;
  }

  public void setNext(DLNode<T> next) {
    this.next = next;
  }

  public DLNode<T> getPrevious() {
    return previous;
  }

  public void setPrevious(DLNode<T> previous) {
    this.previous = previous;
  }
}

/* Test Code
> DLNode<Integer> list = new DLNode<Integer>(1, null, null)
> DLNode<Integer> node2 = new DLNode<Integer>(2, list, null)
> DLNode<Integer> node3 = new DLNode<Integer>(3, node2, null)
> list.getElement()
1
> list.getNext().getElement()
2
> list.getNext().getNext().getElement()
3
> list.getPrevious()
null
> list.getNext().getPrevious().getElement()
1
> list.getNext().getNext().getPrevious().getElement()
2
*/