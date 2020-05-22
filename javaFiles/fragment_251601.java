LinkInt temp = head;
while ( temp.next != null){
    temp = temp.next;
}
//temp.elem = item; -Not needed.

temp1= new LinkInt();
temp1.elem = item;
temp1.next = null;
temp.next = temp1;