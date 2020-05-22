public BTNode getRoot(){
   return this.root;
}
private void  insert (int data, BTNode rootParameter){ // your problem is here

    //case 1: no element in binary tree
    if (root == null){
          // if root is null create a new BTNode and make it root
        BTNode newN= new BTNode(data);
        newN.setLeft(null);
        newN.setRight(null);

        root =newN;
        //System.out.println(root.getData());
        size++;
        return;
        //return root.getData();    

    }
    // other part of your code
}