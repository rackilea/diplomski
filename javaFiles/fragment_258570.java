Node p = first;

  Node elementTobeAdded;

  while(((p.value).compareTo(element)) > 0 && p.next != null)
  {
    p = p.next;
  }

  if(p.next != null)
  {
  elementTobeAdded = new Node(element,p,p.next);
  p.next.prev = elementTobeAdded;
  p = elementTobeAdded.prev;
  }

  else
  {
    elementTobeAdded = new Node(element, p, null);
    p.next = elementTobeAdded;
    elementTobeAdded.next = null;
    last = elementTobeAdded;
  }