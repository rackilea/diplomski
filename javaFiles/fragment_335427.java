public void preorder(Node localroot) {

    if(localroot!=null) {
        localroot.displayNode(); //here!
        preorder(localroot.lchild);
        preorder(localroot.rchild);
        //localroot.displayNode(); not here!
    }
}