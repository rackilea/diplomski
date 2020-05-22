public static IntList Insertion()
{
     IntNode current = head;
     IntNode tail = null;
     while(current != null&& tail != head )
     {
       IntNode next = current;
      for( ; next.next != tail;  next = next.next)
    {
    if(next.value <= next.next.value)
        {
        int temp = next.value;
        next.value = next.next.value;
            next.next.value = temp;
        }
    }
    tail = next;
   current = head;
  }
 return this;