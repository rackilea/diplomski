public interface Node {
    <T> T accept(NodeVisitor<T> visitor);
}

public class ANode implements Node {
    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

public class BNode implements Node {
    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

public interface NodeVisitor<T> {
    T visit(ANode aNode);
    T visit(BNode bNode);
}

public class DtoNodeVisitor implements NodeVisitor<DTO> {
    @Override
    public DTO visit(ANode aNode) {
        return new DTO(); //use ANode to build this.
    }
    @Override
    public DTO visit(BNode bNode) {
        return new DTO(); //use BNode to build.
    }
}