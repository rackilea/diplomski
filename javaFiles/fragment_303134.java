public int sizeOfList() {

  Node zNode = firstNode;
  sizeOfList = 0;

  while( zNode != null) {
     zNode = zNode.next;
     sizeOfList++;
  }
  return sizeOfList; 
}