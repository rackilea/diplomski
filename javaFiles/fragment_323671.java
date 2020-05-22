public void addFirst(Object data){
    Node newNode = new Node();
    newNode.data = data; // No setter necessary

    if (first != null){
        newNode.next = first;  
        first.previous = newNode; //<---added
    }else{
        last = newNode;
    }
    first = newNode;

}