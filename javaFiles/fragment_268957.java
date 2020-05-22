Node p=head; //create a node and point to head

while(p!=null)
{ 
    temp=p.next; 
    p.next=p.prev; 
    p.prev=temp; 
    p=p.next;
}