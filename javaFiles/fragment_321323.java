ASTDecl implements ASTNode
{
  String name;
  Type type;
  Value value;
}

ASTDecls implements ASTNode
{
  ArrayList<ASTDecl> declarations;
}