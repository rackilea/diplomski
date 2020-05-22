Node getSecondAfterMind(Node head) {
  Node slow = head, fast = head;
  while(fast.next.next != NULL) {
    slow = slow.next;
    fast = fast.next.next;
  }
  if slow.next!= NULL && slow.next.next != NULL {
      return slow.next.next;
  }

   return NULL;
}