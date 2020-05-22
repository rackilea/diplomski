public void insertAt(int index,int data) {
    //assumes index <= size of linked list
    int curr = 1;

    if(index < 0)
        return;

    if(index == 0){
        insertFirst(data);
        return;
    }

    Node currNode = head;
    while( curr < index){
        currNode = currNode.nextNode;
        curr++;
    }

    Node newNode = new Node(data);
    newNode.nextNode = currNode.nextNode;
    currNode.nextNode = newNode;
}