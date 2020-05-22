unitNode.accept(new ASTVisitor() {
        @Override
        public boolean visit(VariableDeclarationFragment node) {
            IJavaElement element = node.resolveBinding().getJavaElement();
            if (field.equals(element)) {
                FieldDeclaration fieldDeclaration = (FieldDeclaration)node.getParent();
                IType fieldType = (IType)fieldDeclaration.getType().resolveBinding().getJavaElement();
            }
            return false;
        }
    });