IMethodBinding binding = (IMethodBinding) node.getName().resolveBinding();
ICompilationUnit unit = (ICompilationUnit) binding.getJavaElement().getAncestor( IJavaElement.COMPILATION_UNIT );
if ( unit == null ) {
   // not available, external declaration
}b
ASTParser parser = ASTParser.newParser( AST.JLS8 );
parser.setKind( ASTParser.K_COMPILATION_UNIT );
parser.setSource( unit );
parser.setResolveBindings( true );
CompilationUnit cu = (CompilationUnit) parser.createAST( null );
MethodDeclaration decl = (MethodDeclaration)cu.findDeclaringNode( binding.getKey() );