public void add(T aData)
{       
    if(firstNode!=null){
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
    }
    else {
        firstNode= new Node(aData,null);
    }
    numOfItems++; 
}