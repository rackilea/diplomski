if(a < node.value){
    if(node.left == null){
        //set the new left node
        node.left = new TreeNode(a); //STOP CONDITION!
    }else{
        add(node.left, a);           //Recurse left down the BST!
    }
}