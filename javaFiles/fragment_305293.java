public long minValue() {
      Node curNode = root;
      long min = curNode.getMin();
      while(!curNode.isLeaf()) { // 
           curNode = getNextChild(curNode, min); //it's not immediately clear what min is doing here 
       } 
       //curNode is now the leftmost non-leaf element in the tree
       min = curNode.getMin();
       return min;