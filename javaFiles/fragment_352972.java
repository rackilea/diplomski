class Node
{
    public Object data;
    public Node left;
    public Node right;

    public Node parent;



    public int getLevel() {
        int level = 1;
        Node n = this;
        while (n != null && n.parent != null) {
            level++;
            n = n.parent;
        }
        return level;
   }
}