prevNode = root;
traverser = root;
while(traverser.right != null){
  prevNode = traverser;
  traverser = traverser.right;
}

if(traverser.left != null) {
  prevNode.right = traverser.left;
}else {
  prevNode.right = null;
}