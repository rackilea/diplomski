void deleteBefore(Node q)
{
  if(q == null || q == head) return;

  Node p = null;
  Node n = head;
  while(n != null && n.next != q)
  {
    p = n;
    n = n.next;
  }
  if(n == null) 
    return;

  if(n == head) 
    head = q;
  else 
    p.next = q;
}