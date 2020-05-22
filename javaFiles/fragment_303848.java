class TypeHierarchyVisitor extends ASTVisitor {
    public boolean visit(MethodDeclaration node) {
        // e.g. foo()
        IMethodBinding methodBinding = node.resolveBinding();

        // e.g. class B
        ITypeBinding classBinding = methodBinding.getDeclaringClass();

        // e.g. class TestOverride
        ITypeBinding superclassBinding = classBinding.getSuperclass();
        if (superclassBinding != null) {
            for (IMethodBinding parentBinding: superclassBinding.getDeclaredMethods()) {
                if (methodBinding.overrides(parentBinding)) {
                    // now you know `node` overrides a method and
                    // you can add the `super` statement
                }
            }
        }
        return super.visit(node);
    }
}