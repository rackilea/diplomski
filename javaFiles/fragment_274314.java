interface NodeVisitor {
    void visit(ExprNode node);
    void visit(VarNode node);
}

class Interpreter implements NodeVisitor {
    @Override
    public void visit(ExprNode node) {
        // custom logic here
    }

    @Override
    public void visit(VarNode node) {
        // custom logic here
    }
}

private class ASTNode {
    public abstract void accept(NodeVisitor visitor);
}

private class ExprNode extends ASTNode {
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}

private class VarNode extends ASTNode {
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}

public static void main(String[] args) {
    ASTNode node = new ExprNode();
    node.accept(new Interpreter());
}