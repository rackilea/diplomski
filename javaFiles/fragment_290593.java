void setSuperClass(TypeDeclaration typeDecl, String qualifiedName) {
    AST ast = typeDecl.getAST();
    Name name = ast.newName(qualifiedName);
    Type type = ast.newSimpleType(name);
    typeDecl.setSuperclassType(type);
}