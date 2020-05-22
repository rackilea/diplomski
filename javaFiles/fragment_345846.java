class Node {
    private Node parent;
    private ArrayList<Node> sons=new ArrayList<Node>();

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public void addSon(Node son) {
        if(!this.sons.contains(son)) {
            this.sons.add(son);

            if(son.parent != null) {
                son.parent.sons.remove(son);
            }

            son.setParent(this);
        }
    }
}