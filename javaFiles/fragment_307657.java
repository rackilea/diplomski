. . . 
} else {
   Node left = replaceNodes(currentNode.leftChild, itemId, desc);
   if(left != null) { return left; }
   return replaceNodes(currentNode.rightChild, itemId, desc);
}
. . .