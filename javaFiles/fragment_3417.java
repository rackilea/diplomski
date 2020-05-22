public bool equalsSubList(CharNode other) {
  CharNode node1 = this;  
  CharNode node2 = other;  
  while (node1 != null && node2 != null) { 
    // compare data from both nodes
    node1 = node1.getNext();
    node2 = node2.getNext();
  }
  // return true if all nodes where compared and are equal
}