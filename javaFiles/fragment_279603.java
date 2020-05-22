Node Delete(Node head, int position) {
  // Complete this method
    int pos = 0;
    Node current = head;
    Node previous = null;

    if(position == 0 && head.next == null){
        return null;
    }

    if(head==null){
        return null;
    }

    while(current.next!=null){
        pos = pos + 1;
        current = current.next;
        if(pos==position){
            previous.next = current.next;
            break; // Terminate the Loop
        }
        previous = current;

    }
    return head;
}