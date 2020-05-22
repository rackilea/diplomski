public boolean search(int value) {

    BSTree.CompareSet();

    if (data == value) return true;

    if (data > value && left!=null)
        return left.search(value);
    else if(data < value && right != null) 
        return right.search(value);
    return false;   
}