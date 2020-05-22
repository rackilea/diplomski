public void addLast(Item item) {
    if (item == null) {
      // When a null element is entered
      throw new java.lang.NullPointerException("Item cannot be null");
    }
    Node < Item > newnode = new Node < Item > ();
    newnode.item = item;
    if (numberOfItems == 0) {
      // When there are no elements
      front = newnode;
      back = newnode;
    } else {
      // When there are >=1 elements
      newnode.next = back;
      newnode.prev = null;
      back.prev = newnode;
      back = newnode;
    }
    numberOfItems++;
  }