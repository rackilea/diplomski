if(root.getLeft()!=null && search(root.getLeft(), node)) {
      return true;
    }

    if(root.getRight()!=null && search(root.getRight(), node)){
       return true;
    }
    return false;