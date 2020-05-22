Node Reverse(Node head) {
   Node temp = head.next;
   head.next = head.prev;
   head.prev = temp;

   return temp==null?head:Reverse(temp);