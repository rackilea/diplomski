public void push(Key k, Val v){
    if (root == null) {
        root = new Node(k, v);
        size++;
        return;
    }
    push(root,k,v);
}