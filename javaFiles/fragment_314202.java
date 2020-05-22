public void setPositionFinder(String methodName) throws JavaModelException
{
    //findMethod(methodName);
    IType type = this.javaProject.findType(this.className);
    ICompilationUnit unit = type.getCompilationUnit();
    ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setSource(unit);
    parser.setResolveBindings(true);
    CompilationUnit cunit = (CompilationUnit) parser.createAST(null);
    //ASTNode root = parser.createAST(null);

    final String name = this.newMethodName;

    cunit.accept(new ASTVisitor() {
        public boolean visit(MethodInvocation methodInvocation)
        {
            String methodName = methodInvocation.getName().toString();
            System.out.println(methodName);
            if (methodName.equals(name))
            {
                startPosition = methodInvocation.getStartPosition();
                length = methodInvocation.getLength();
                System.out.printf("startPosition %d - Length %d", startPosition, length);       
            }
            return false;
        }
    });
}