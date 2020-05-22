public boolean add(Comparable obj){
       OrderedListNode node = new OrderedListNode(obj);

       // When the list is empty
       if (head.next == tail)
       {
           head.next = node;
           node.next = tail;
           tail.prev = node;
           return true;
       }


       // When the element to be added is less than the first element in the list
       if (obj.compareTo(head.next.theItem) < 0)
       {
           node.next = head.next;
           head.next = node;
           return true;
       }

       //When there is an element in the list

       OrderedListNode current = head.next;
       OrderedListNode previous = head;
       while (current != tail && node.theItem.compareTo(current.theItem) >= 0)
       {
          previous = current;
          current = current.next;
       }

       previous.next = node;
       node.next = current;

       return true;
   }