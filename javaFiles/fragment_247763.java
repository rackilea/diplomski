public void add(T aData)
{       
    boolean found =false;
    Node currNode=firstNode;

    while(currNode != null){
        if(currNode.data.equals(aData)){
            currNode.addF();
            found=true;
            break;
        }
        currNode= currNode.next;
    }

    if(!found){
        Node tempNode=firstNode;
        firstNode= new Node(aData,tempNode);
    }
    numOfItems++; 
}