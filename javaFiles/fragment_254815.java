Node newNode = new Node(someInt);
Node current = head;
//check head first
if (current.data > newNode.data) {
  newNode.next = head;
  head = newNode;
}

//check body
else {
  while(true){
    if(current == tail){
      current.next = newNode;
      tail = newNode;
      break;
    }   
    if(current.data < someInt && current.next.data >= someInt){
      newNode.next = current.next;
      current.next = newNode;
      break;
    }
    current = current.next;
  }
}