while(fast != null && fast.next.next != null)
{
    slow = slow.next;
    if(fast.next!=null)
        fast = fast.next.next;
    else break;
}