ASTParser parser = ASTParser.newParser(AST.JLS3); // or JLS_4 for java 7 and above

parser.setKind(ASTParser.K_COMPILATION_UNIT);
parser.setSource(source); // give your java source here as char array
parser.setResolveBindings(true);

CompilationUnit compilationUnit = parser.createAST(null);