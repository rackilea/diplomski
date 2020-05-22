if(root.getLeft()!=null){
       return search(root.getLeft(), node);
    }

    if(root.getRight()!=null){
        return search(root.getRight(), node);
    }