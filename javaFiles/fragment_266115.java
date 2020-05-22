public class MyBusinessElement implements IntrusiveListElement<MyBusinessElement> {
  private MyBusinessElement prev;
  private MyBusinessElement next;

  public void setNext(MyBusinessElement next) {
    this.next = next;
  }

      public MyBusinessElement getNext() {
    return next;
  }

  public void setPrev(MyBusinessElement prev) {
    this.prev = prev;
  }

  public MyBusinessElement getPrev() {
    return prev;
  }
}