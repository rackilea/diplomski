public LinkedIntList removeEvens(){
    LinkedIntList b = new LinkedIntList();

    if(front == null) {  
        System.out.println("The list inputed it empty");
    }
    else {   
        ListNode current = front.next; // current node always points to an odd node
        b.addTail(front); // add first node (even) to list
        front = current: // front now points to first odd node.

        // while there is odd node and the next node (even node) is not null
        while(current!=null && current.next != null) { // need to remove even node
                ListNode toBeAdded = current.next; // save the node to be removed
                current.next = current.next.next;
                b.addTail(toBeAdded);
                current = current.next;
        }
    }

    size -= b.size(); // new list size is old list size minus total removed nodes.
    return b;
}