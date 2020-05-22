public boolean insert(TreeNode node){

    if( root == null)
        root = node;

    else{
        TreeNode parent = null;
        TreeNode current = root;
        while( current != null){
            if( node.getData().getValue().compareTo(current.getData().getValue()) <0){
                parent = current;
                current = current.getLeft();
            }
            else if( node.getData().getValue().compareTo(current.getData().getValue()) >0){
                parent = current;
                current = current.getRight();
            }
            else
                return false;
        }
        if(node.getData().getValue().compareTo(parent.getData().getValue()) < 0)
            parent.setLeft(node);
        else
            parent.setRight(node);
        }

        size++;
        return true;
    }