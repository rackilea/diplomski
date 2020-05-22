if(tree.left() != null){
  int j = findMin(tree.left());
  if (j<min){
      min = j;
  }
}