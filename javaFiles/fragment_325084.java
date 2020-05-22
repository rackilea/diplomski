public static Tree BFS(Node node){
    Queue queue= new Queue();
    node.visited= true;
    queue.enqueue(node);

    while (!queue.isEmpty()){
        Node r= queue.dequeue();
        for (int i= 0; i < r.childen.size(); i++){
            Node s= (Node)r.childen.get(i);
            if (s.visited == false){
                s.visited= true;
                queue.enqueue(s);
            }
            else{
                //Remove edge here
                r.childen.remove(i);
                i--;
            }
        }
    }
    Tree tree= new Tree(node);
    return tree;
}