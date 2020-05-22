. . . 
} else {
   Node left = replaceNodes(currentNode.leftChild, itemId, desc);
   if(left != null) { return left; }
   Node right = replaceNodes(currentNode.rightChild, itemId, desc);
   if(right != null) { return right; }
}
. . .