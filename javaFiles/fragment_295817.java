class Visitor {
    Stack<Node> stack = new Stack<Node>();

//    . . .

    void visitPlus(PlusExp pe) {
        pe.left.accept(this);
        pe.right.accept(this);
        Node b = stack.pop();
        Node a = stack.pop();
        stack.push(new BinOp(BinOp.PLUS, a, b));
    }