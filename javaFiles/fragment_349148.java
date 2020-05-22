private Node recursiveInsert(Node head, Node node) {
    if (head == null)
        head = node;
    else if (node.data < head.data)
        head.left = recursiveInsert(head.left, node);
    else if (node.data > head.data)
        head.right = recursiveInsert(head.right, node);

    return head;
}

public Node insert(Node node){
    if(this.head==null){
        this.head=node;
    }else{
        recursiveInsert(this.head,node);
    }
    return this.head;
}