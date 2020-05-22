Node lastElement = root;
while(lastElement.next !=null){
   lastElement=lastElement.next;
}
temp=new Node(data);
lastElement.next=temp;