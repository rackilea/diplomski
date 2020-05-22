public List mergeSortList(Node head)
{
    if ( (head == null) || (head.next == null))
       return head;
    Node middle = this.findMiddle(head);
    Node first = head;
    Node second = middle.next;
    middle.next = null; 
    Node left = mergeSortList(first);
    Node right = mergeSortList(second);
    return merge(left, right);
 }