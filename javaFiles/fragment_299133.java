public class NodeBase {
    //your code
    public void accept(IVisitor visitor) {
        visitor.visit(this); 
        for (NodeBase node : getChildren()) {
            node.accept(visitor);
        }
    }
}