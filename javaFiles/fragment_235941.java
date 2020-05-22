public void inOrder(){                
    // implement this method using non-recursive solution
   if(m_root==null){
      return;
   }
   Stack<BSTNode> myStack= new Stack<BSTNode>();
   BSTNode current=m_root;
   while (current!= null){
      myStack.push(current);
      current=current.getLeft();
   }
   while (!myStack.isEmpty()){
      current=(BSTNode)myStack.pop();
      System.out.print(current.getInfo()+" ");
      if(current.getRight() != null){
         current=current.getRight();
         while (current!= null){
            myStack.push(current);
            current=current.getLeft();
         }
      }
   }

}