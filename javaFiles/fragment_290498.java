public void delete(Node n) {
    if(Node.numOfUsers == 0 || n == null) return; // 0 nodes or null parameter.

    Node temp = first;

    if(temp.next == null) { //only one node
        temp = null; //simply delete it
    } else {
        while(temp.next != n) {
            temp = temp.next;
            if(temp == first) { //if we circle the entire list and don't find n, it doesn't  exist.
                return;
            }
        }
        temp.next = n.next; // perform the switch, deleting n
    }
}