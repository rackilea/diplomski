public Node reverse(Node current)
{
 if (current== null || current.next==null) return current;
 Node nextItem = current.next;
 current.next = null;
 Node reverseRest = reverse(nextItem);
 nextItem.next = current;
 return reverseRest;
}