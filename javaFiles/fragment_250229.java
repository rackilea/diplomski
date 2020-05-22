public ListNode oddEvenList(ListNode head) 
{
    //Check that there are AT LEAST TWO ELEMENTS
    if (head == null || head.next == null)
         return head;

    //Initialize pointers
    ListNode lastOdd = head;
    ListNode lastEven = head.next;
    ListNode firstEven = lastEven;

    //Continue as long as there is at least two more elements
    while (lastOdd.next != null && lastEven.next != null)
    {
            //Connect the last odd element with the element next to the
            //last even one (such element is odd)
            lastOdd.next = lastEven.next;
            //Advance lastOdd to such element
            lastOdd = lastOdd.next;

            //Do the same for the even list, only inverting the roles
            lastEven.next = lastOdd.next;
            lastEven = lastEven.next;
     }

     //Now connect the last odd element with the first even element
     //This join the two list together
     lastOdd.next = firstEven ;

     return head;
}