public static Tree BFS(Graph G, Node node){
    Queue queue= new Queue();
    Queue treeQueue= new Queue();
    ArrayList<Node> tempV= new ArrayList<Node>();
    tempV.add(node);
    queue.enqueue(node);
    Node root= new Node(node.data);
    treeQueue.enqueue(root);

    while (!queue.isEmpty()){
        Node r= queue.dequeue();
        Node t= treeQueue.dequeue();
        for (int i= 0; i < r.childen.size(); i++){
            Node s= (Node)r.childen.get(i);
            if (tempV.indexOf(s) < 0){
                tempV.add(s);
                Node child= new Node(s.data);
                t.childen.add(child);
                queue.enqueue(s);
                treeQueue.enqueue(child);
            }
        }
    }
    Tree tree= new Tree(root);
    return tree;
}