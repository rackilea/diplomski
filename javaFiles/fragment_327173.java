public ListNode deleteNode(ListNode start, ListNode deleteMe)
{
    ListNode prev = start;
    if(start == deleteMe) return start.next;
    while(prev.next != null) {
        if(prev.next == deleteMe)
            deleteNextNode(prev);
        prev = prev.next;
    }
    return start;
}