public void traverse (Position<Integer> root, List<String> input, boolean isLeft){
   if(tree.hasLeft(root) || tree.hasRight(root)){
       if(isLeft)
          input.add("Y->Q"+root.element());
       else
          input.add("N->Q"+root.element());
   }
   else{
       if(isLeft)
          input.add("Y->R"+root.element());
       else
          input.add("N->R"+root.element());
   }
   if (tree.hasLeft(root)){
       traverse(tree.left(root), input, true);
   }
   if (tree.hasRight(root)){
       traverse(tree.right(root), input, false);
   }
}