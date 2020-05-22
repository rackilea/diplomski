ICompilationUnit unit = JavaCore.createCompilationUnitFrom(file);
ASTParser parser = ASTParser.newParser(AST.JLS3);
parser.setKind(ASTParser.K_COMPILATION_UNIT);
parser.setResolveBindings(true);
parser.setSource(unit);
// Parse the source code and generate an AST.
CompilationUnit ast = (CompilationUnit) parser.createAST(null);