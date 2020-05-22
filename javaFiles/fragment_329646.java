BasicForStatement:
    for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement

ForInit:
    StatementExpressionList
    LocalVariableDeclaration

LocalVariableDeclaration:
    VariableModifiersopt Type VariableDeclarators

VariableDeclarators:
    VariableDeclarator
    VariableDeclarators , VariableDeclarator