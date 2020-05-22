public interface IntrusiveListElement<E extends<IntrusiveListElement<E>> {
  public void setNext(E next);
  public E getNext();
  public void setPrev(E prev);
  public E getPrev();
}

public class IntrusiveList<E extends IntrusiveListElement<E>> implements List<E> {
  // implement your run-of-the-mill double-linked list here
}