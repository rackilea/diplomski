private int weight(TreeNode current){
            if(current == null){
                return 0;
            }
            else{
                return 1 + (this.weight(current.getLeft())
                         +  this.weight(current.getRight()));
            }