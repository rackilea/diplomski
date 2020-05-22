static <E extends Comparable<E>> E secondMax(Node<E> head)
{
  if(head == null) return null;

  E max2 = null;
  E max1 = head.key;
  for(Node<E> curr=head.next; curr!=null; curr=curr.next)
  {
    if(curr.key.compareTo(max1) >= 0)
    {
      max2 = max1;
      max1 = curr.key;
    }
    else if(max2 == null || curr.key.compareTo(max2) > 0)
    {
      max2 = curr.key;
    }
  }
  return max2;
}

static class Node<E>
{
  E key;
  Node<E> next;
  public Node(E k)
  {
    key = k;
  }
}