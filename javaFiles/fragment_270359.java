public void remove(int data) { // Head is not required in param, should be field variable
    Node ptr = head;

    while(ptr!=null && ptr.data != data) // search for the node
    {
        ptr = ptr.next;
    }

    if(ptr == null) {
        System.out.println("Not Found");
        return;
    }

    if(ptr.prev == null) {// match found with first node
        head = ptr.next;
    }
    else{
        ptr.prev.next = ptr.next;
    }
    if(ptr.next == null){// match found with last node
        tail = ptr.prev;
    }
    else{
        ptr.next.prev = ptr.prev;
    }       
}