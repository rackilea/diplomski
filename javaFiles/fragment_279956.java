List<AbstractTypeDeclaration> types = cu.types();
for(AbstractTypeDeclaration type : types) {
    if(type.getNodeType() == ASTNode.TYPE_DECLARATION) {
        // Class def found
        List<BodyDeclaration> bodies = type.bodyDeclarations();
        for(BodyDeclaration body : bodies) {
            if(body.getNodeType() == ASTNode.METHOD_DECLARATION) {
                MethodDeclaration method = (MethodDeclaration)body;
                System.out.println("method declaration: ");
                System.out.println("name: " + method.getName().getFullyQualifiedName());
                System.out.println("modifiers: " + method.getModifiers());
                System.out.println("return type: " + method.getReturnType2().toString());
            }
        }
    }
}