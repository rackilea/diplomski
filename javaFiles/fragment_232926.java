int counter = 0;
Node head = curr;// save pointer to head of linked list.
while (curr != null) {
    if (counter+1 == position) {
    insert.next = curr.next;
    curr.next = insert;
    break;      
    }
curr = curr.next;
counter++;
}
return head;