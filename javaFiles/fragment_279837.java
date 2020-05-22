class MyTreeScanner extends TreePathScanner<Void, Void> {
    private final Trees trees;

    public MyTreeScanner(Trees trees) {
        this.trees = trees;
    }

    @Override
    public Void visitVariable(VariableTree tree, Void aVoid) {
        super.visitVariable(variableTree, aVoid);
        // This method might be invoked in case of
        //  1. method field definition
        //  2. method parameter
        //  3. local variable declaration
        // Therefore you have to filter out somehow what you don't need.
        if(tree.getKind() == Tree.Kind.VARIABLE) {
            Element variable = trees.getElement(trees.getPath(getCurrentPath().getCompilationUnit(), tree));
            MyUseAnnotation annotation = variable.getAnnotation(MyUseAnnotation.class);
            // Here you have your annotation.
            // You can process it now.
        }
        return aVoid;
    }
}