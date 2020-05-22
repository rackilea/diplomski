BasicForStatement:
    for ( ForInit ; Expression ; ForUpdate ) Statement

ForStatementNoShortIf:
    for ( ForInit ; Expression ; ForUpdate ) StatementNoShortIf

ForInit:
    StatementExpressionList
    LocalVariableDeclaration

ForUpdate:
    StatementExpressionList


StatementExpressionList:
    StatementExpression
    StatementExpressionList , StatementExpression