public void addInOrder(Employee employee){

if (head==null){//if your list is empty just insert it in the beginning
head=new Node(employee);
return;
}//end if(head==null)


if (head.getNext()==null)//if we have one node only{
if(position.getEmployee().compareTo(employee) > 0){//if it should be replaced than put it in the beginning
Node node=new Node(employee);
node.setNext(head);
head=node;
node.getNext().setPrevious(node);
return;
    }
else{
//add it to the end,i am assuming you know how to do that,if not than comment on my answer.
return;
       }
}
else{
Node position=head;
while(position!=null){
if(position.getEmployee().compareTo(employee) > 0){
Node node=new Node(employee);           //you should add the node before position
node.setNext(position);                 //so set the node's next to position
node.setPrevious(position.getPrevious());//set the node's previous to position's previous
position.getPrevious.setNext(node);      //set the next of position's previous to node
return;//and exit
           }
position=position.getNext();//else continue looping through the list
      }
//if we looped through the whole array and we haven't inserted the node so we didn't              exit the method,than add it to the end.
 Node n=new Node(employee);

 position.setNext(new Node(n);
 n.setPrevious(position);
   }


}