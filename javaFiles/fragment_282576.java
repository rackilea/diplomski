@Override
    public Void visitIf(IfTree node, Void p) {
        try {
            JTextComponent editor = EditorRegistry.lastFocusedComponent();
            if (editor.getDocument() == info.getDocument()) {
                InputOutput io = IOProvider.getDefault().getIO("Analysis of " + info.getFileObject().getName(),
                        true);
                ExpressionTree exTree = node.getCondition();
                if (exTree.getKind() == Tree.Kind.PARENTHESIZED) {
                    ParenthesizedTree parTree = (ParenthesizedTree) exTree;
                    BinaryTree conditionTree = (BinaryTree) parTree.getExpression();
                    ExpressionTree identTree = conditionTree.getLeftOperand();
                    if (identTree.getKind() == Tree.Kind.IDENTIFIER) {
                        Name name = ((IdentifierTree) identTree).getName();
                        io.getOut().println("Hurray, this is the name of the identifier in the left operand: " + name.toString());
                    }


           io.getOut().close();
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
            return null;        
}