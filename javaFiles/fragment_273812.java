Node newNode = new Node(newData);
Node temp = head;
if (temp == null) {
    insertToHead(newNode);
    newNode.incrementCount();
    nodeCount++;
} else {
   while(temp != null){
      if(temp.getData().equals(newNode.getData())){
        temp.incrementCount();
        break;
      }
      temp = temp.getNext();
   }

   // didn't find anything, prepend to the list
   if(temp == null){
    insertToHead(newNode);
    nodeCount++;
   }
}