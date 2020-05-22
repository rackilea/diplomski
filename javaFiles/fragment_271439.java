private boolean processEnumType(TypeDeclaration node) {
    if (!isEnum(node)) {
        return false;
    }
    final CSEnum theEnum = new CSEnum(typeName(node));
    mapVisibility(node, theEnum);
    mapJavadoc(node, theEnum);
    addType(theEnum);

    node.accept(new ASTVisitor() {
        public boolean visit(VariableDeclarationFragment node) {
            theEnum.addValue(identifier(node.getName()));
            return false;
        }

        @Override
        public boolean visit(MethodDeclaration node) {
            if (node.isConstructor() && isPrivate(node)) {
                return false;
            }
            unsupportedConstruct(node, "Enum can contain only fields and a private constructor.");
            return false;
        }
    });
    return true;
}