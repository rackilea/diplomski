Node removeTail() {
     if (head == null) {
         return null;
     }

     Node tail = head.previous;
     Node newTail = tail.previous;
     newTail.next = head;
     head.previous = newTail;

     if (head == tail) {
         head = null;
     }
     --size;
     return tail; // If so desired.
}