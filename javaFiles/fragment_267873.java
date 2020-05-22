public void insertAtEnd(Item item){
    if (first == null)
        insertAtBeginning(Item item);
    else{
        Node t = first;
        while(t!=null && t.next!=null){
            t=t.next;
        }

        Node old = t;
        t = new Node();
        t.item = item;
        old.next = t;
    }        
}