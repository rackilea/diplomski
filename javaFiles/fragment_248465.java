public TreeNode<City> search(City parent, TreeNode<City> t){
    if (t.getCity().equals(parent)) {
        return t;
    }
    else if (t.hasLeftChild()){
        return search(parent,t.getLeftChild());
    }
    else if(t.hasNextSibling()){
        return search(parent,t.getNextSibling());
    }
    return null;
}