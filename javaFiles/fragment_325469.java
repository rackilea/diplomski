if(root.getLeft()!=null){
        search(root.getLeft(), node);
    }

    if(root.getRight()!=null){
        search(root.getRight(), node);
    }