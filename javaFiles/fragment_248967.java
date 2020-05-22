IJavaProject javaProject = ...obtain it somehow, possibly through getAdapter() on editor?
String name = ...from editor?...

ASTParser parser = ASTParser.newParser(AST.JLS3);
parser.setKind(ASTParser.K_COMPILATION_UNIT);
parser.setSource(c_text);
parser.setResolveBindings(true);
parser.setProject(javaProject);
parser.setUnitName(name);
return (CompilationUnit) parser.createAST(null);