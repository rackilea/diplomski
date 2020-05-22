ASTParser parser = ASTParser.newParser(AST.JLS4);
parser.setSource(charArray);
parser.setKind(ASTParser.K_COMPILATION_UNIT);

final CompilationUnit cu = (CompilationUnit) 
parser.createAST(null);
cu.accept(new ASTVisitor(){..methods..});