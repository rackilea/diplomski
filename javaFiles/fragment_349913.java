private void startVisit(IFile file) {
    ICompilationUnit icu = JavaCore.createCompilationUnitFrom(file);

    ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setResolveBindings(true);
    parser.setSource(icu);

    CompilationUnit cu = (CompilationUnit) parser.createAST(null);
    cu.accept(this);
}