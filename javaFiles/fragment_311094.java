/*Base case.*/
   /*If the next node in the AddressList is null add the ListNode to that node.*/
   if(currentNode.getNext() == null)
   {
      currentNode = currentNode.getNext();
      currentNode = new ListNode(name, telephoneNum, email, address, dob);
   }