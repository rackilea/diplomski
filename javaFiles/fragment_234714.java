class StringStack {

  private StringNode head = null;

  public boolean isEmpty(){
    return head == null;
  }

  public void push(String item) {
    StringNode oldHead = head;
    head = new StringNode(item);
    head.next = oldHead;
  }

  public String pop() throws StringStackException {
    if (isEmpty()) {
      throw new StringStackException("Empty Stack");
    }
    String result = head.item;
    head = head.next;
    return result;
  }

  public String peek() throws StringStackException {
    if (isEmpty()) {
      throw new StringStackException("Stack underflow");
    }
    return head.item;
  }

  static class StringNode {

    String item;
    StringNode next;

    public StringNode(String item) {
      this.item = item;
    }
  }
}