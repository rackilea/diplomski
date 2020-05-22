AST ast = targetCompilationUnit.getAST();

    FieldDeclaration oldFieldDeclaration = ASTNodeSearchUtil.getFieldDeclarationNode(field, sourceCompilationUnit);
    Type oldType = oldFieldDeclaration.getType();

    Type newType = (Type) ASTNode.copySubtree(ast, oldType);