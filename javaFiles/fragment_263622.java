Node reverseList(Node head) {
 Node curr = null;
 Node node = head;
 Node next = null;
 while (node) {
  next = curr; // Here, curr is null, so next = null
  curr = node;
  System.out.println("curr has data " + node.data);
  curr.next = next; // You are here doing 'curr.next = null' (see before)

  node = node.next;
 }
 return curr;
}