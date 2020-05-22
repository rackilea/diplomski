FieldDeclaration:
  {FieldModifier} UnannType VariableDeclaratorList ;

VariableDeclaratorList:
  VariableDeclarator {, VariableDeclarator}

VariableDeclarator:
  VariableDeclaratorId [= VariableInitializer]