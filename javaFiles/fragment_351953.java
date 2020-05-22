public class LinkedList {
  Node head;
  Node tail;
  final int MAX_SIZE;
  int currentSize; 

  public LinkedList(int MAX_SIZE) {
    this.head = null;
    this.tail = null;
    this.MAX_SIZE = MAX_SIZE;
    this.currentSize = 0;
  }

  public void append(String val) {
    Node n = new Node(val);

    if (currentSize < MAX_SIZE) {   
      if (head == null) {
        head = n;
        tail = n;
        return;
      }

      Node current = head;
      while (current.next != null) {
        current = current.next;
      }

      current.next = n;
      currentSize++;
    }
    else {
      head = head.next;
      currentSize--;
      append(val);
    }
  }

public class Node {
  String val;
  Node next;

  public Node(String val) {
    this.val = val;
    this.next = null;
  }
}