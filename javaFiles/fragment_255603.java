static boolean allE(Tree<Integer> x)
{
    if (x.isEmpty())
        return true;
    else {
        if (x.getValue()%2 != 0) return false;    
    }
    if(!allE(x.getLeft()) || !allE(x.getRight())) 
        return false;
    return true;
  }