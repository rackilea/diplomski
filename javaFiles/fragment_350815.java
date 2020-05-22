BasicForStatement:
  for ( [ForInit] ; [Expression] ; [ForUpdate] ) Statement

BasicForStatementNoShortIf:
  for ( [ForInit] ; [Expression] ; [ForUpdate] ) StatementNoShortIf

ForInit:
  StatementExpressionList 
  LocalVariableDeclaration