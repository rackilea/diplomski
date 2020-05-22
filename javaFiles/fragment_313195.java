public class Node {
    private Integer id;
    private Node parent;
    private List<Node> children;
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public List<Node> getChildren()
    {
        return children;
    }
    public void setChildren(List<Node> children)
    {
        this.children = children;
        for (Node child : children) {
            child.parent = this;
        }
    }
    public Node getParent() {
        return parent;
    }
}