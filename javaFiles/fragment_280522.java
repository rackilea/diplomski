class Tree{
    ArrayList<Node> nodes;
    private static int n = 0;
    //...
    class Node{
        private int id;
        public Node(){
            id = n++;
            Tree.this.nodes.add(this);
        }
    }
}