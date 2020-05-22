for (int i = 0; i < myStringChars.length; i++){
        TreeNode parent = null;
        if (i == 0){
            parent = new TreeNode<>("A", null);
            parent.setLevel(lvl);
            lvl++;
        }
        else{
            //set level
            if((i == 3)||(i == 7)||(i == 15)){
                lvl++;
            }
            else if (myStringChars[i].toCharArray()[0]%2 == 1){
                parent = new TreeNode<>(myStringChars[i], lcaTree.get((i/2)-1));
                lcaTree.get((i/2)-1).setRightChild(parent);
                parent.setLevel(lvl);
            }
            else{
                parent = new TreeNode<>(myStringChars[i], lcaTree.get(i/2));
                lcaTree.get((i/2)).setLeftChild(parent);
                parent.setLevel(lvl);
            }
            lcaTree.add(parent); //<--- move out!
        }
    }