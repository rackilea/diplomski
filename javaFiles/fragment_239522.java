public TNode insertNode(TNode item, int d){
    if(item == null){
        TNode node = new TNode(d);
        if (root == null) { 
            root = node;
        }
        return node
    }
    ... rest of method isn't changed...