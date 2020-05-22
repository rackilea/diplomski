public void deleteId(int ID){
    Node previousNode=head;
    Node currentNode=head;
    while(currentNode!=null){
        if(currentNode.id==ID){
             previousNode.next=currentNode.next;
             currentNode=currentNode.next;
        }else{
             previousNode=currentNode;
             currentNode=currentNode.next;
        }
    }
    System.out.println("Deleted " + ID);
}