public void traverse(Node n){
    if (n==null)
        return;
    doSomethingWith(n);
    if (!conditionIsMet(n)){
        traverse(n.left);
        traverse(n.right);
    }
}