Node p = first;
  while (p.value.compareTo(element) < 0 && p.next != null) {
    p = p.next;
  }
  if (p.value.compareTo(element) > 0) {
    Node toAdd = new Node(element, p.prev, p);
    p.prev = toAdd;
    if (toAdd.prev != null) {
        toAdd.prev.next = toAdd;
    }else {
      first = toAdd;
    }
  }else {
    Node toAdd = new Node(element, p, p.next);
    p.next = toAdd;
    if (toAdd.next != null) {
        toAdd.next.prev = toAdd;
    }else {
      last = toAdd;
    }
  }