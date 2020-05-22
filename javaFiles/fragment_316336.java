public boolean findMove(E e){
    Node previous=head;
    Node current=head;
    while(current !=null){
        if(e.equals(current.item)){
            //Found the item
            previous.next=current.next;
            current.next=head;
            head=current;
            System.out.println("True");
            return true;
        }
        previous = current;
        current=current.next;
    }
    System.out.println("False");
    return false;
}