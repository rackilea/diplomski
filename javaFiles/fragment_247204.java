private TreeIF<DoctorIF> getTreeChild(TreeIF<DoctorIF> tree_, int id){
    if (tree_.getRoot().getId()==id && id!=1)return tree_;
    else{
        ListIF<TreeIF<DoctorIF>> list = tree_.getChildren();
        IteratorIF<TreeIF<DoctorIF>> it = list.getIterator();
        while(it.hasNext()){
            TreeIF<DoctorIF> subtree = getTreeChild(it.getNext(), id);
            //subtree might be null at this point
            //In that case, subtree.getRoot() will throw a NullPointerException
            if (subtree == null) continue; //This will prevent the NullPointerException
            if (subtree.getRoot()!=null && subtree.getRoot().getId()==id)return subtree;
        }
    }
    return null;
}