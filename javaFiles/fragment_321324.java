ASTRoot {
  ASTDecls declarations;
  ASTFunctions functions;
}

ASTFunctions {
  ASTDecls args;
  ASTBody body;
  ..
}

ASTBody {
  ArrayList<ASTStatement> statements;
  ...
}