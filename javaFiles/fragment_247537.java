private Node recursiveInOrderSuccessor(Node root2,int i) {
        if(root2 == null) return null;
        Node successor = null, succ2 = null;
        if(root2.data == i) {
            successor = root2.right;
            while(successor.left != null){
                successor = successor.left;
            }
            return successor;
        }

        if(root2.data > i){
            successor = root2;
            succ2 = recursiveInOrderSuccessor(root2.left, i);
            if(succ2 != null && succ2.data < successor.data)
                return succ2;
            else
                return successor;
        }
        else{
            return recursiveInOrderSuccessor(root2.right, i);
        }
    }