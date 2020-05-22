public void insertEnd(Object obj) {
        if (head == null) {
            head = new SListNode(obj);
        } else {
            SListNode node = head.next;
            if (node != null {
              while (true) {
                  node = node.next;
                  if (node == null) 
                     break;
              }
            }
            node = new SListNode(obj);
        }
        size++;
  }