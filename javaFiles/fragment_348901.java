// Create the Java parser and parse the source code into an abstract syntax tree
ASTParser parser = ASTParser.newParser(AST.JLS3);
parser.setSource(sourceCodeString.toCharArray());
CompilationUnit result = (CompilationUnit) parser.createAST(null);
result.accept(new ASTVisitor() {
  public boolean visit(NumberLiteral n) {
    System.out.println("Found number literal in source code: " + n.getToken());
  }
});