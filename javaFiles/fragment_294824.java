private Block createStatements(AST ast) {
    Block result = ast.newBlock();

    VariableDeclarationStatement conDeclStmt = createVariableDeclarationStatement(ast);
    result.statements().add(conDeclStmt);
    TryStatement tryStmt = createTryStatement(ast);
    result.statements().add(tryStmt);

    return result;
}

private VariableDeclarationStatement createVariableDeclarationStatement(AST ast) {
    VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
    fragment.setName(ast.newSimpleName("con"));
    fragment.setInitializer(ast.newNullLiteral());
    VariableDeclarationStatement result = ast.newVariableDeclarationStatement(fragment);
    return result;
}

private TryStatement createTryStatement(AST ast) {
    TryStatement result = ast.newTryStatement();

    Block body = ast.newBlock();
    ExpressionStatement assignment = createAssignmentStatement(ast);
    body.statements().add(assignment);
    result.setBody(body);

    CatchClause catchClause = createCatchClause(ast);
    result.catchClauses().add(catchClause);

    return result;
}

private ExpressionStatement createAssignmentStatement(AST ast) {
    MethodInvocation invocation = ast.newMethodInvocation();
    invocation.setExpression(ast.newSimpleName("DataSource"));
    invocation.setName(ast.newSimpleName("getConnection"));

    Assignment assignment = ast.newAssignment();
    assignment.setLeftHandSide(ast.newSimpleName("con"));
    assignment.setOperator(Operator.ASSIGN);
    assignment.setRightHandSide(invocation);
    return ast.newExpressionStatement(assignment);
}

private CatchClause createCatchClause(AST ast) {
    CatchClause result = ast.newCatchClause();

    SingleVariableDeclaration exDecl = ast.newSingleVariableDeclaration();
    exDecl.setType(ast.newSimpleType(ast.newSimpleName("Exception")));
    exDecl.setName(ast.newSimpleName("ex"));
    result.setException(exDecl);

    Block body = ast.newBlock();
    ...

    return result;
}